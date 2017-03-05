package com.itk.cms.service;

import com.itk.base.model.ShopInfo;
import com.itk.base.service.ShopInfoService;
import com.itk.cms.model.NearbyBusinessInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by enchen on 2/21/17.
 */
@Service
public class NearByBusinessInfoServiceImpl {

    @Autowired
    private NearByBusinessInfoService nearByBusinessInfoService;

    public int addNearByBusinessInfo(NearbyBusinessInfo nearbyBusinessInfo){
        return nearByBusinessInfoService.addNearByBusinessInfo(nearbyBusinessInfo);
    }

    public int updateNearByBusinessInfo(NearbyBusinessInfo nearbyBusinessInfo){
        return nearByBusinessInfoService.updateNearByBusinessInfo(nearbyBusinessInfo);
    }

    public int delNearByBusinessInfo(Long id){
        return nearByBusinessInfoService.delNearByBusinessInfo(id);
    }

    public NearbyBusinessInfo selectByPrimaryKey(Long id){
        return nearByBusinessInfoService.selectByPrimaryKey(id);
    }

}
