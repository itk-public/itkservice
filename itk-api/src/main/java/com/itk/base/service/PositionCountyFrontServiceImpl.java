package com.itk.base.service;

import com.itk.base.model.PositionCounty;
import com.itk.util.Constant;
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
public class PositionCountyFrontServiceImpl {

    @Autowired
    private PositionCountyService countyService;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<PositionCounty> selectCountyByCityId(Long cityId) throws Exception{
        byte[] countyList = redisTemplate.getConnectionFactory().getConnection().get(cityId.toString().getBytes());
        if(countyList == null){
            List<PositionCounty> tempList = countyService.selectCountyByCityId(cityId);
            redisTemplate.getConnectionFactory().getConnection().setEx(cityId.toString().getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(tempList));
            return tempList;
        }
        return (List<PositionCounty>) SerializationUtils.deserialize(countyList);
    }

    public PositionCounty selectCountyByCountyId(Long countyId) throws Exception{
        byte[] positionDetail = redisTemplate.getConnectionFactory().getConnection().get("basePositionDetail".getBytes());
        if (positionDetail == null) {
            HashMap<String, Object> positionDetailMap = new HashMap<>();
            positionDetailMap.put(countyId.toString(), countyService.selectCountyByCountyId(countyId));
            redisTemplate.getConnectionFactory().getConnection().setEx("basePositionDetail".getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(positionDetailMap));
        }
        HashMap<String, Object> detailMap = (HashMap<String, Object>) SerializationUtils.deserialize(positionDetail);
        if (detailMap.containsKey(countyId) && detailMap.get(countyId) != null) {
            return (PositionCounty) detailMap.get(countyId);
        }
        detailMap.put(countyId.toString(),countyService.selectCountyByCountyId(countyId));
        redisTemplate.getConnectionFactory().getConnection().setEx("basePositionDetail".getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(detailMap));
        return countyService.selectCountyByCountyId(countyId);
    }
}
