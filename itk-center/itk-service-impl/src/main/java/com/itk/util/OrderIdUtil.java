package com.itk.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.SerializationUtils;

import java.time.LocalDateTime;

/**
 * Created by enchen on 5/5/17.
 */
public class OrderIdUtil {
    private static final long REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS = 259200L;
    @Autowired
    private static RedisTemplate redisTemplate;

    /**
     * 数字转换成 参数传入 长度 的 字符串
     *
     * @param source 需要转换的数字
     * @return 转换后的字符串
     */
    public static String formatCode(int source, int length) {
        String s = "";
        if (source < (int) Math.pow(10, length - 1)) {
            int len = length - ("" + source).length();
            for (int i = 0; i < len; i++) {
                s = s + "0";
            }
            return s + source;
        }
        return "" + source;
    }

    public static String orderSuffixGenerator() {
        String key = "orderIDSuffix";
        byte[] orderIdSuffix = redisTemplate.getConnectionFactory().getConnection().get(key.getBytes());
        if (orderIdSuffix == null) {
            redisTemplate.getConnectionFactory().getConnection().setEx(key.getBytes(), REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(0));
        } else {
            Integer temp = (Integer) SerializationUtils.deserialize(orderIdSuffix) + 1;
            if (temp > 99999) {
                redisTemplate.getConnectionFactory().getConnection().setEx(key.getBytes(), REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(0));
            } else {
                redisTemplate.getConnectionFactory().getConnection().setEx(key.getBytes(), REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(temp));
            }
        }
        byte[] nowOrderIdSuffix = redisTemplate.getConnectionFactory().getConnection().get(key.getBytes());
        Integer nowId = (Integer) SerializationUtils.deserialize(nowOrderIdSuffix);
        return OrderIdUtil.formatCode(nowId, 5);
    }

    public static String orderIDGenerator(){
        StringBuffer orderID = new StringBuffer();
        LocalDateTime localDateTime = LocalDateTime.now();
        orderID.append(OrderIdUtil.formatCode(localDateTime.getYear(), 2));
        orderID.append(OrderIdUtil.formatCode(localDateTime.getMonthValue(), 2));
        orderID.append(OrderIdUtil.formatCode(localDateTime.getDayOfMonth(), 2));
        orderID.append(OrderIdUtil.formatCode(localDateTime.getHour(), 2));
        orderID.append(OrderIdUtil.formatCode(localDateTime.getMinute(), 2));
        orderID.append(OrderIdUtil.formatCode(localDateTime.getSecond(), 2));
        orderID.append(OrderIdUtil.formatCode(Math.abs(orderID.hashCode() % 1024), 4));
        orderID.append(OrderIdUtil.orderSuffixGenerator());
        return orderID.toString();
    }
}
