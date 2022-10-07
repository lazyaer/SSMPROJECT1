package com.lazya.ssm.service;

import com.lazya.ssm.domain.Role;
import com.lazya.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Title: IUserService
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 01 14 56
 */
public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll(int page, int size) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRole(String userId) throws Exception;

    void addRoleToUser( String userId,String[] roleId) throws Exception;
}
