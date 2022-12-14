package com.lazya.ssm.domain;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * Title: UserInfo
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 01 14 22
 */
public class UserInfo {
        private String id;
        private String username;
        private String email;
        private String password;
        private String phoneNum;
        private int status;
        private String statusStr;
        private List<Role> roles;

        public UserInfo() {
                String UUIDRandom = UUID.randomUUID().toString();
                this.id = UUIDRandom.replace("-","").toUpperCase(Locale.ROOT);
        }

        public UserInfo(String username, String email, String password, String phoneNum, int userstatus, String userstatusStr, List<Role> roles) {
                this.username = username;
                this.email = email;
                this.password = password;
                this.phoneNum = phoneNum;
                this.status = userstatus;
                this.statusStr = userstatusStr;
                this.roles = roles;
                String UUIDRandom = UUID.randomUUID().toString();
                this.id = UUIDRandom.replace("-","").toUpperCase(Locale.ROOT);
        }

        @Override
        public String toString() {
                return "UserInfo{" +
                        "id='" + id + '\'' +
                        ", username='" + username + '\'' +
                        ", email='" + email + '\'' +
                        ", password='" + password + '\'' +
                        ", phoneNum='" + phoneNum + '\'' +
                        ", status=" + status +
                        ", statusStr='" + statusStr + '\'' +
                        ", roles=" + roles +
                        '}';
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getPhoneNum() {
                return phoneNum;
        }

        public void setPhoneNum(String phoneNum) {
                this.phoneNum = phoneNum;
        }

        public int getStatus() {
                return status;
        }

        public void setStatus(int status) {
                this.status = status;
        }

        public String getStatusStr() {
                if(status == 0){
                        statusStr="未开启";
                }else if(status == 1){
                        statusStr="开启";
                }
                return statusStr;
        }

        public void setStatusStr(String statusStr) {
                this.statusStr = statusStr;
        }

        public List<Role> getRoles() {
                return roles;
        }

        public void setRoles(List<Role> roles) {
                this.roles = roles;
        }
}
