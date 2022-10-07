package com.lazya.ssm.domain;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * Title: Role
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 01 14 23
 */
public class Role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<UserInfo> userInfos;

    public Role() {
        String UUIDRandom = UUID.randomUUID().toString();
        this.id = UUIDRandom.replace("-","").toUpperCase(Locale.ROOT);
    }

    public Role(String roleName, String roleDesc, List<Permission> permissions, List<UserInfo> userInfos) {
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.permissions = permissions;
        this.userInfos = userInfos;
        String UUIDRandom = UUID.randomUUID().toString();
        this.id = UUIDRandom.replace("-","").toUpperCase(Locale.ROOT);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", permissions=" + permissions +
                ", userInfos=" + userInfos +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return userInfos;
    }

    public void setUsers(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }

}
