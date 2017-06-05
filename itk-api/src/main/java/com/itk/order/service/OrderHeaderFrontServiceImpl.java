package com.itk.order.service;

import com.itk.order.model.OrderHeader;
import com.itk.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import java.util.Date;

/**
 * Created by enchen on 5/5/17.
 */
@Service
public class OrderHeaderFrontServiceImpl {

    @Autowired
    OrderHeaderService orderHeaderService;

    @Autowired
    private RedisTemplate redisTemplate;

    public int addOrderHeader(OrderHeader orderHeader){
        orderHeader.setCreateTime(new Date());

        //byte[] orderIdSuffix = redisTemplate.getConnectionFactory().getConnection().get("orderIdSuffix".getBytes());

//        RedisAtomicLong redisAtomicLong = new RedisAtomicLong("orderIdSuffix",redisTemplate.getConnectionFactory());
//
//        long origin = redisAtomicLong.get();
//
//        System.out.println("################origin: " + origin);

//        if (orderIdSuffix == null) {
//
//            positionDetailMap.put(provinceId.toString(), provinceService.selectProvinceByProvinceId(provinceId));
//            redisTemplate.getConnectionFactory().getConnection().setEx("basePositionDetail".getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(positionDetailMap));
//        }
//        HashMap<String, Object> detailMap = (HashMap<String, Object>) SerializationUtils.deserialize(positionDetail);
//        if (detailMap.containsKey(provinceId) && detailMap.get(provinceId) != null) {
//            return (PositionProvince) detailMap.get(provinceId);
//        }
//        detailMap.put(provinceId.toString(),provinceService.selectProvinceByProvinceId(provinceId));
//        redisTemplate.getConnectionFactory().getConnection().setEx("basePositionDetail".getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(detailMap));

        return  orderHeaderService.addOrderHeader(orderHeader);
    }

    public int delOrderHeader(Long id){
        return orderHeaderService.delOrderHeader(id);
    }

    public int updateOrderHeader(OrderHeader orderHeader){
        return orderHeaderService.updateOrderHeader(orderHeader);
    }

    public OrderHeader selectByOrderId(String orderId){
        return orderHeaderService.selectByOrderId(orderId);
    }

    public void test(final String key) {
        byte[] orderIdSuffix = redisTemplate.getConnectionFactory().getConnection().get(key.getBytes());
        if(orderIdSuffix == null){
            redisTemplate.getConnectionFactory().getConnection().setNX(key.getBytes(),"0".getBytes());
            System.out.println("############origin:" + "0");
        }else{
            String testId = (String) SerializationUtils.deserialize(orderIdSuffix);
            Long nowId = (Long)SerializationUtils.deserialize(orderIdSuffix) + 1;
            redisTemplate.getConnectionFactory().getConnection().setNX(key.getBytes(),("" + nowId).getBytes());
            System.out.println("############origin:" + nowId);
            //System.out.println("############origin:" + testId);
           // System.out.println("############origin:" + redisTemplate.opsForValue().get(key));

        }
    }

}
