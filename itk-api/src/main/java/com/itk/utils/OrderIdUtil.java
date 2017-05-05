package com.itk.utils;

/**
 * Created by enchen on 5/5/17.
 */
public class OrderIdUtil {

    /**
     * 一位数字前面补0 变成两位,两位则不变
     *
     * @param source
     *            需要转换的数字
     *
     * @return 转换后的字符串
     */
    public static String format(int source){
        return ("" + source).length() < 2 ? "0" + source : "" + source;
    }

    /**
     * 将订单规则的年月日时分秒取出来的摸,不足4位,补0
     *
     * @param source
     *            需要转换的数字
     *
     * @return 转换后的字符串
     */
    public static String formatHashCode(int source){
        String s = "";
        if(source < 1000){
            int len = 4 - ("" + source).length();
            for (int i = 0; i < len; i++) {
                s = s + "0";
            }
            return s + source;
        }
        return "" + source;
    }
}
