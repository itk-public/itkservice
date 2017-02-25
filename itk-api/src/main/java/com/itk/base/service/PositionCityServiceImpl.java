package com.itk.base.service;

import com.itk.base.model.PositionCity;
import com.itk.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
@Service
public class PositionCityServiceImpl {

    @Autowired
    private PositionCityService cityService;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<PositionCity> selectCityByProvinceId(Long provinceId) throws Exception{
        byte[] cityList = redisTemplate.getConnectionFactory().getConnection().get(provinceId.toString().getBytes());
        if(cityList == null){
            List<PositionCity> tempList = cityService.selectCityByProvinceId(provinceId);
            redisTemplate.getConnectionFactory().getConnection().setEx(provinceId.toString().getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(tempList));
            return tempList;
        }
        return (List<PositionCity>) SerializationUtils.deserialize(cityList);
    }

    public PositionCity selectCityByCityId(Long cityId) throws Exception{
        byte[] positionDetail = redisTemplate.getConnectionFactory().getConnection().get("basePositionDetail".getBytes());
        if (positionDetail == null) {
            HashMap<String, Object> positionDetailMap = new HashMap<>();
            positionDetailMap.put(cityId.toString(), cityService.selectCityByCityId(cityId));
            redisTemplate.getConnectionFactory().getConnection().setEx("basePositionDetail".getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(positionDetailMap));
        }
        HashMap<String, Object> detailMap = (HashMap<String, Object>) SerializationUtils.deserialize(positionDetail);
        if (detailMap.containsKey(cityId) && detailMap.get(cityId) != null) {
            return (PositionCity) detailMap.get(cityId);
        }
        detailMap.put(cityId.toString(),cityService.selectCityByCityId(cityId));
        redisTemplate.getConnectionFactory().getConnection().setEx("basePositionDetail".getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(detailMap));
        return cityService.selectCityByCityId(cityId);
    }
}
