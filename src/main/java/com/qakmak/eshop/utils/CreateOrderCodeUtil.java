package com.qakmak.eshop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author tapakkur
 * @ProjectName online-shop
 * @Date 2019/3/24 20:57
 */
public class CreateOrderCodeUtil {

    // 获取订单编号code
    public static String getCode(){
        String head = getTimeString(); // 长度16位
        String tail = getRandomString(4); // 长度4位
        String code = head + tail;
        return code;
    }

    // 将时间转字符串格式
    public static String getTimeString(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String head = sdf.format(date);
        return head;
    }

    //length用户要求产生字符串的长度
    public static String getRandomString(int length){
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< length; i++){
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}
