package com.lazya.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.lazya.ssm.domain.Permission;
import com.lazya.ssm.service.IPromissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Title: PermissionController
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 03 16 27
 */
//资源权限管理
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPromissionService promissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAl(@RequestParam(name="page",required=true,defaultValue="1") Integer page,
                               @RequestParam(name="size",required=true,defaultValue="4")Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = promissionService.findAll(page,size);
        PageInfo pagePermission = new PageInfo(permissionList);
        mv.addObject("pagePermission",pagePermission);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception{
        promissionService.save(permission);
        return "redirect:findAll.do";
    }

}
