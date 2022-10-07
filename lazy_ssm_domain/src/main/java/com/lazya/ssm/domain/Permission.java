package com.lazya.ssm.domain;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * Title: Permission
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 01 14 25
 */
public class Permission {
        private String id;
        private String permissionName;
        private String url;
        private List<Role> roles;

        public Permission() {
                String UUIDRandom = UUID.randomUUID().toString();
                this.id = UUIDRandom.replace("-","").toUpperCase(Locale.ROOT);
        }

        public Permission(String permissionName, String url, List<Role> roles) {
                this.permissionName = permissionName;
                this.url = url;
                this.roles = roles;
                String UUIDRandom = UUID.randomUUID().toString();
                this.id = UUIDRandom.replace("-","").toUpperCase(Locale.ROOT);
        }

        @Override
        public String toString() {
                return "Permission{" +
                        "id='" + id + '\'' +
                        ", permissionName='" + permissionName + '\'' +
                        ", url='" + url + '\'' +
                        ", roles=" + roles +
                        '}';
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getPermissionName() {
                return permissionName;
        }

        public void setPermissionName(String permissionName) {
                this.permissionName = permissionName;
        }

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }

        public List<Role> getRoles() {
                return roles;
        }

        public void setRoles(List<Role> roles) {
                this.roles = roles;
        }
}
