package com.itk.cms.service;

import com.itk.cms.model.NearbyBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by enchen on 2/21/17.
 */
@Service
public class NearByBusinessFrontServiceImpl {

    @Autowired
    private NearByBusinessService nearByBusinessService;

    public int addNearByBusiness(NearbyBusiness nearbyBusiness){
        return nearByBusinessService.addNearByBusiness(nearbyBusiness);
    }

    public int updateNearByBusiness(NearbyBusiness nearbyBusiness){
        return nearByBusinessService.updateNearByBusiness(nearbyBusiness);
    }

    public int delNearByBusiness(Long id){
        return nearByBusinessService.delNearByBusiness(id);
    }

    public NearbyBusiness selectByPrimaryKey(Long id){
        return nearByBusinessService.selectByPrimaryKey(id);
    }

}
