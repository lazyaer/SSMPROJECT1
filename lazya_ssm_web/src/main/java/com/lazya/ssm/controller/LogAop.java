package com.lazya.ssm.controller;

import com.lazya.ssm.domain.SysLog;
import com.lazya.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Title: LogAop
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 07 13 18
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;
    // 访问时间
    private Date startTime;
    // 访问的类
    private Class executionClass;
    // 访问的方法
    private Method executionMethod;
    @Before("execution(* com.lazya.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws Exception {
        // 访问时间
        startTime = new Date();
        // 获取访问的类
        executionClass = jp.getTarget().getClass();
        // 获取访问的方法
        // 获取访问的方法的名称
        String methodName = jp.getSignature().getName();
        // 获取访问的方法的参数
        Object[] args = jp.getArgs();
        // 无参数
        if (args == null || args.length == 0) {
            // 只能获取无参数方法
            executionMethod = executionClass.getDeclaredMethod(methodName);
        } else {
            // 有参数，就将args中所有元素遍历，获取对应的Class,装入到一个Class[]
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            // 获取有参数方法
            executionMethod = executionClass.getDeclaredMethod(methodName, classArgs);
        }
    }
    @After("execution(* com.lazya.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
    // 获取类上的@RequestMapping对象
        if (executionClass != LogAop.class) {
            RequestMapping classAnnotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                // 获取方法上的@RequestMapping对象
                RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    // 它的值应该是类上的@RequestMapping的value+方法上的@RequestMapping的value
                    String url = "";

                    url = classAnnotation.value()[0] + methodAnnotation.value()[0];

                    SysLog sysLog = new SysLog();

                    // 获取访问时长
                    Long executionTime = System.currentTimeMillis() - startTime.getTime();
                    // 将sysLog对象属性封装
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setUrl(url);
                    // 获取ip
                    String ip = request.getRemoteAddr();
                    sysLog.setIp(ip);
                    // 可以通过securityContext获取，也可以从request.getSession中获取
                    //request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
                    SecurityContext context = SecurityContextHolder.getContext();
                    String username = ((User) (context.getAuthentication().getPrincipal())).getUsername();
                    sysLog.setUsername(username);
                    sysLog.setMethod("[类名]" + executionClass.getName() + "[方法名]" + executionMethod.getName());
                    sysLog.setVisitTime(startTime);
                    // 调用Service，调用dao将sysLog insert数据库
                    sysLogService.save(sysLog);
                }
            }
        }
    }
}
