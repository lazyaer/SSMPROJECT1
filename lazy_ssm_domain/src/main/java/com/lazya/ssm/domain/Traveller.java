package com.lazya.ssm.domain;

import java.util.Locale;
import java.util.UUID;

/**
 * Title: Traveller
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 09 30 13 30
 */
public class Traveller {
    private String id;
    private String username;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;
    private String travellerTypeStr;

    public Traveller() {
        String UUIDRandom = UUID.randomUUID().toString();
        this.id = UUIDRandom.replace("-","").toUpperCase(Locale.ROOT);
    }

    public Traveller(String username, String sex, String phoneNum, Integer credentialsType, String credentialsTypeStr, String credentialsNum, Integer travellerType, String travellerTypeStr) {
        this.username = username;
        this.sex = sex;
        this.phoneNum = phoneNum;
        this.credentialsType = credentialsType;
        this.credentialsTypeStr = credentialsTypeStr;
        this.credentialsNum = credentialsNum;
        this.travellerType = travellerType;
        this.travellerTypeStr = travellerTypeStr;
        String UUIDRandom = UUID.randomUUID().toString();
        this.id = UUIDRandom.replace("-","").toUpperCase(Locale.ROOT);
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", credentialsType=" + credentialsType +
                ", credentialsTypeStr='" + credentialsTypeStr + '\'' +
                ", credentialsNum='" + credentialsNum + '\'' +
                ", travellerType=" + travellerType +
                ", travellerTypeStr='" + travellerTypeStr + '\'' +
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        //0 身份证 1 护照 2军官证
        if(credentialsType != null){
            if(credentialsType == 0){
                credentialsTypeStr = "身份证";
            }else if(credentialsType == 1){
                credentialsTypeStr = "护照";
            }else if(credentialsType == 2){
                credentialsTypeStr = "军官证";
            }
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        if(travellerType != null){
            if(travellerType == 0){
                travellerTypeStr = "成人";
            }else if(travellerType == 1){
                travellerTypeStr = "儿童";
            }
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
