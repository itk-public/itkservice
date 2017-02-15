package com.itk.user.service.impl;

import java.util.Random;

/**
 * Created by zhouhui on 2017/2/14.
 */
public class SecurityCodeUtil {

    public static String getRandomString(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
