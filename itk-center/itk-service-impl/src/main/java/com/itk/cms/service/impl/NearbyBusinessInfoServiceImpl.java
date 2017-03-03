package com.itk.cms.service.impl;

import com.itk.cms.mapper.NearbyBusinessInfoMapper;
import com.itk.cms.model.NearbyBusinessInfo;
import com.itk.cms.service.NearbyBusinessInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhouhui on 2017/3/3.
 */
public class NearbyBusinessInfoServiceImpl implements NearbyBusinessInfoService {

    @Autowired
    private NearbyBusinessInfoMapper nearbyBusinessInfoMapper;

    @Override
    public int addNearbyBusinessInfo(NearbyBusinessInfo nearbyBusinessInfo) {
        return nearbyBusinessInfoMapper.insertSelective(nearbyBusinessInfo);
    }

    @Override
    public int updateNearbyBusinessInfo(NearbyBusinessInfo nearbyBusinessInfo) {
        return nearbyBusinessInfoMapper.updateByPrimaryKeySelective(nearbyBusinessInfo);
    }

    @Override
    public int deleNearbyBusinessInfo(NearbyBusinessInfo nearbyBusinessInfo) {
        return nearbyBusinessInfoMapper.updateByPrimaryKeySelective(nearbyBusinessInfo);
    }

    @Override
    public NearbyBusinessInfo selectByPrimaryKey(Long id) {
        return nearbyBusinessInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public NearbyBusinessInfo selectNearbyBusinessInfosByNearbyBusinessId(Long nearByBusinessId) {
        return nearbyBusinessInfoMapper.selectNearbyBusinessInfosByNearbyBusinessId(nearByBusinessId);
    }
}
