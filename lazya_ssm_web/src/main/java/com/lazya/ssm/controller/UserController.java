package com.lazya.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.lazya.ssm.domain.Role;
import com.lazya.ssm.domain.UserInfo;
import com.lazya.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Title: UserController
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 03 13 09
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public IUserService userService;

    //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name="userId",required = true) String userId,
                              @RequestParam(name="ids",required = true)String[] roleIds) throws Exception {

        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //根据用户id查询用户
        UserInfo userInfo = userService.findById(userId);
        //根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRole(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page",required=true,defaultValue="1") Integer page,
                                @RequestParam(name="size",required=true,defaultValue="4")Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList= userService.findAll(page,size);
        PageInfo pageUser = new PageInfo(userList);
        mv.addObject("pageUser",pageUser);
        mv.setViewName("user-list");
        return mv;
    }


    @RequestMapping("/save.do")
    //authentication.principal.username获取当前登陆用户名
    @PreAuthorize(" 'lazya' == authentication.principal.username")
    public String save(UserInfo userInfo) throws Exception {
            userService.save(userInfo);
            return "redirect:findAll.do";
    }


    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }
}
