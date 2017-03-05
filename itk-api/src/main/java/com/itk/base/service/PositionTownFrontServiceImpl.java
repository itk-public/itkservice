package com.itk.base.service;

import com.itk.base.model.PositionTown;
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
public class PositionTownFrontServiceImpl {

    @Autowired
    private PositionTownService townService;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<PositionTown> selectTownByCountyId(Long countyId) throws Exception{
        byte[] townList = redisTemplate.getConnectionFactory().getConnection().get(countyId.toString().getBytes());
        if(townList == null){
            List<PositionTown> tempList = townService.selectTownByCountyId(countyId);
            redisTemplate.getConnectionFactory().getConnection().setEx(countyId.toString().getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(tempList));
            return tempList;
        }
        return (List<PositionTown>) SerializationUtils.deserialize(townList);
    }

    public PositionTown selectTownByTownId(Long townId) throws Exception{
        byte[] positionDetail = redisTemplate.getConnectionFactory().getConnection().get("basePositionDetail".getBytes());
        if (positionDetail == null) {
            HashMap<String, Object> positionDetailMap = new HashMap<>();
            positionDetailMap.put(townId.toString(), townService.selectTownByTownId(townId));
            redisTemplate.getConnectionFactory().getConnection().setEx("basePositionDetail".getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(positionDetailMap));
        }
        HashMap<String, Object> detailMap = (HashMap<String, Object>) SerializationUtils.deserialize(positionDetail);
        if (detailMap.containsKey(townId) && detailMap.get(townId) != null) {
            return (PositionTown) detailMap.get(townId);
        }
        detailMap.put(townId.toString(),townService.selectTownByTownId(townId));
        redisTemplate.getConnectionFactory().getConnection().setEx("basePositionDetail".getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(detailMap));
        return townService.selectTownByTownId(townId);
    }
}
