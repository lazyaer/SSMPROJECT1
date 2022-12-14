package com.lazya.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.lazya.ssm.domain.SysLog;
import com.lazya.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Title: SysLogController
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 07 15 25
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page",required=true,defaultValue="1") Integer page,
                                @RequestParam(name="size",required=true,defaultValue="4")Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAll(page,size);
        PageInfo pageSysLog = new PageInfo(sysLogList);
        mv.addObject("pageSysLog",pageSysLog);
        mv.setViewName("syslog-list");
        return mv;
    }
}
