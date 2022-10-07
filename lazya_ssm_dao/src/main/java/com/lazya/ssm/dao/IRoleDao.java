package com.lazya.ssm.dao;

import com.lazya.ssm.domain.Permission;
import com.lazya.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * Title: IRoleDao
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 01 16 27
 */
public interface IRoleDao {
    //根据用户id查询出所有对应角色
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true , column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "permissions", javaType = java.util.List.class, many = @Many(select = "com.lazya.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findByUserId(String userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(id,roleName,roleDesc) values (#{id},#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    @Select("select * from role where id=#{roleId}")
    @Results({
            @Result(id = true , column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "permissions", javaType = java.util.List.class, many = @Many(select = "com.lazya.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(String roleId) throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(String roleId) throws Exception;

    @Insert("insert into role_permission(roleId,permissionId) values (#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;
}
