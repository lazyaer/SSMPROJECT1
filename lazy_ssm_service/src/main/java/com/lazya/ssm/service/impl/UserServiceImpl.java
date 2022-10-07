package com.lazya.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.lazya.ssm.dao.IUserDao;
import com.lazya.ssm.domain.Role;
import com.lazya.ssm.domain.UserInfo;
import com.lazya.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: UserServiceImpl
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 01 14 59
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {
        for(String roleId:roleIds){
            userDao.addRoleToUser(userId,roleId);
        }
    }

    @Override
    public List<Role> findOtherRole(String userId) throws Exception {
        return userDao.findOtherRole(userId);
    }

    //查询所有用户信息----user-list
    @Override
    public List<UserInfo> findAll(int page, int size) throws Exception{
        PageHelper.startPage(page,size);
        return userDao.findAll();
    }
    //添加用户----user-add
    @Override
    public void save(UserInfo userInfo) throws Exception {
        //对密码进行加密处理
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails,如果状态未0即为未启用也会设置登陆失败
//        User user = new User(userInfo.getUsername(),userInfo.getPassword(),getAuthority(userInfo.getRoles()));
          User user = new User(userInfo.getUsername(),userInfo.getPassword(), userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));

        return user;
    }

    //作用是返回一个List集合，集合中装入的是角色的描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Role role : roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

}
