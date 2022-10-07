package com.lazya.ssm.service;

import com.lazya.ssm.domain.Permission;
import com.lazya.ssm.domain.Role;

import java.util.List;

/**
 * Title: IRoleService
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 03 15 35
 */
public interface IRoleService {
    List<Role> findAll(int page, int size) throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
