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
     * 数字转换成 参数传入 长度 的 字符串
     *
     * @param source
     *            需要转换的数字
     *
     * @return 转换后的字符串
     */
    public static String formatHashCode(int source, int length){
        String s = "";
        if(source < (int)Math.pow(10,length - 1)){
            int len = length - ("" + source).length();
            for (int i = 0; i < len; i++) {
                s = s + "0";
            }
            return s + source;
        }
        return "" + source;
    }
}
