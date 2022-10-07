package com.lazya.ssm.domain;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * Title: Member
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 09 30 13 30
 */
public class Member {

    private String id;
    private String username;
    private String nickname;
    private String phoneNum;
    private String email;

    public Member() {
        String UUIDRandom = UUID.randomUUID().toString();
        this.id = UUIDRandom.replace("-","").toUpperCase(Locale.ROOT);
    }

    public Member(String username, String nickname, String phoneNum, String email) {
        this.username = username;
        this.nickname = nickname;
        this.phoneNum = phoneNum;
        this.email = email;
        String UUIDRandom = UUID.randomUUID().toString();
        this.id = UUIDRandom.replace("-","").toUpperCase(Locale.ROOT);
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
