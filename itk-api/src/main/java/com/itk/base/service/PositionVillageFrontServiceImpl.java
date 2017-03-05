package com.itk.base.service;

import com.itk.base.model.PositionVillage;
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
public class PositionVillageFrontServiceImpl {

    @Autowired
    private PositionVillageService villageService;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<PositionVillage> selectVillageByTownId(Long townId) throws Exception{
        byte[] villageList = redisTemplate.getConnectionFactory().getConnection().get(townId.toString().getBytes());
        if(villageList == null){
            List<PositionVillage> tempList = villageService.selectVillageByTownId(townId);
            redisTemplate.getConnectionFactory().getConnection().setEx(townId.toString().getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(tempList));
            return tempList;
        }
        return (List<PositionVillage>) SerializationUtils.deserialize(villageList);
    }

    public PositionVillage selectVillageByVillageId(Long villageId) throws Exception{
        byte[] positionDetail = redisTemplate.getConnectionFactory().getConnection().get("basePositionDetail".getBytes());
        if (positionDetail == null) {
            HashMap<String, Object> positionDetailMap = new HashMap<>();
            positionDetailMap.put(villageId.toString(), villageService.selectVillageByVillageId(villageId));
            redisTemplate.getConnectionFactory().getConnection().setEx("basePositionDetail".getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(positionDetailMap));
        }
        HashMap<String, Object> detailMap = (HashMap<String, Object>) SerializationUtils.deserialize(positionDetail);
        if (detailMap.containsKey(villageId) && detailMap.get(villageId) != null) {
            return (PositionVillage) detailMap.get(villageId);
        }
        detailMap.put(villageId.toString(),villageService.selectVillageByVillageId(villageId));
        redisTemplate.getConnectionFactory().getConnection().setEx("basePositionDetail".getBytes(), Constant.REDIS_TOCKEN_EXPIRE_TIME_BY_SECONDS, SerializationUtils.serialize(detailMap));
        return villageService.selectVillageByVillageId(villageId);
    }
}
