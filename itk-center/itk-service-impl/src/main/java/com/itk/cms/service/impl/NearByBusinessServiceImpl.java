package com.itk.cms.service.impl;

import com.itk.cms.mapper.NearbyBusinessMapper;
import com.itk.cms.model.NearbyBusiness;
import com.itk.cms.service.NearByBusinessService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by enchen on 2/21/17.
 */
public class NearByBusinessServiceImpl implements NearByBusinessService {

    @Autowired
    private NearbyBusinessMapper nearbyBusinessMapper;


    @Override
    public int addNearByBusiness(NearbyBusiness nearbyBusiness) {
        return nearbyBusinessMapper.insertSelective(nearbyBusiness);
    }

    @Override
    public int updateNearByBusiness(NearbyBusiness nearbyBusiness) {
        return nearbyBusinessMapper.updateByPrimaryKeySelective(nearbyBusiness);
    }

    @Override
    public int delNearByBusiness(Long nearbyBusinessId) {
        NearbyBusiness nearbyBusinessInfo = nearbyBusinessMapper.selectByPrimaryKey(nearbyBusinessId);
        nearbyBusinessInfo.setIsDel(1);// isDel 0: 可用  1: 已删除
        return nearbyBusinessMapper.deleteByPrimaryKey(nearbyBusinessId);
    }

    @Override
    public NearbyBusiness selectByPrimaryKey(Long nearbyBusinessId) {
        return nearbyBusinessMapper.selectByPrimaryKey(nearbyBusinessId);
    }
}
