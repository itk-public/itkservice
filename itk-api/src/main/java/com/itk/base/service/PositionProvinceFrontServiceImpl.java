package com.itk.base.service;

import com.itk.base.model.PositionProvince;
import com.itk.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
@Service
public class PositionProvinceFrontServiceImpl {

    @Autowired
    private PositionProvinceService provinceService;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<PositionProvince> selectAllProvince() throws Exception {
        byte[] provinceList = redisTemplate.getConnectionFactory().getConnection().get("allProvince".getBytes());
        if (provinceList == null) {
            List<PositionProvince> tempList = provinceService.selectAllProvince();
            redisTemplate.getConnectionFactory().getConnection().setEx("allProvince".getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(tempList));
            return tempList;
        }
        return (List<PositionProvince>) SerializationUtils.deserialize(provinceList);
    }

    public PositionProvince selectProvinceByProvinceId(Integer provinceId) throws Exception {
        byte[] positionDetail = redisTemplate.getConnectionFactory().getConnection().get("basePositionDetail".getBytes());
        if (positionDetail == null) {
            HashMap<String, Object> positionDetailMap = new HashMap<>();
            positionDetailMap.put(provinceId.toString(), provinceService.selectProvinceByProvinceId(provinceId));
            redisTemplate.getConnectionFactory().getConnection().setEx("basePositionDetail".getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(positionDetailMap));
        }
        HashMap<String, Object> detailMap = (HashMap<String, Object>) SerializationUtils.deserialize(positionDetail);
        if (detailMap.containsKey(provinceId) && detailMap.get(provinceId) != null) {
            return (PositionProvince) detailMap.get(provinceId);
        }
        detailMap.put(provinceId.toString(),provinceService.selectProvinceByProvinceId(provinceId));
        redisTemplate.getConnectionFactory().getConnection().setEx("basePositionDetail".getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(detailMap));
        return provinceService.selectProvinceByProvinceId(provinceId);
    }
}
