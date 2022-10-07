package com.lazya.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Title: DateUtils
 * Description:
 *
 * @author 懒闲人(ldg)
 * @version 1.0
 * @Date 2022 09 27 15 36
 */
public class DateUtils {

    //日期转换成字符串
    public static String DateToString(String patt, Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }
    //字符串转换成日期
    public static Date StringToDate(String patt, String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date date = sdf.parse(str);
        return date;
    }
}
