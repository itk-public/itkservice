package com.itk.cms.service.impl;

import com.itk.cms.mapper.NearbyBusinessInfoMapper;
import com.itk.cms.model.NearbyBusinessInfo;
import com.itk.cms.service.NearByBusinessInfoService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by enchen on 2/21/17.
 */
public class NearByBusinessInfoServiceImpl implements NearByBusinessInfoService {

    @Autowired
    private NearbyBusinessInfoMapper nearbyBusinessInfoMapper;


    @Override
    public int addNearByBusinessInfo(NearbyBusinessInfo nearbyBusinessInfo) {
        return nearbyBusinessInfoMapper.insertSelective(nearbyBusinessInfo);
    }

    @Override
    public int updateNearByBusinessInfo(NearbyBusinessInfo nearbyBusinessInfo) {
        return nearbyBusinessInfoMapper.updateByPrimaryKeySelective(nearbyBusinessInfo);
    }

    @Override
    public int delNearByBusinessInfo(Long nearbyBusinessId) {
        NearbyBusinessInfo nearbyBusinessInfo = nearbyBusinessInfoMapper.selectByPrimaryKey(nearbyBusinessId);
        nearbyBusinessInfo.setIsDel(1);// isDel 0: 可用  1: 已删除
        return nearbyBusinessInfoMapper.deleteByPrimaryKey(nearbyBusinessId);
    }

    @Override
    public NearbyBusinessInfo selectByPrimaryKey(Long nearbyBusinessId) {
        return nearbyBusinessInfoMapper.selectByPrimaryKey(nearbyBusinessId);
    }
}
