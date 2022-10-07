package com.lazya.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Title: BCryptPasswordEncoderUtils
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 10 01 17 25
 */
public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "lazya";
        String pwd = encodePassword(password);
        System.out.println(pwd);
    }
}