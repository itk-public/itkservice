package com.itk.cms.service;

import com.itk.cms.model.NearbyBusiness;


/**
 * Created by enchen on 2/21/17.
 */
public interface NearByBusinessService {

    int addNearByBusiness(NearbyBusiness nearbyBusiness);

    int updateNearByBusiness(NearbyBusiness nearbyBusiness);

    int delNearByBusiness(Long nearbyBusinessId);

    NearbyBusiness selectByPrimaryKey(Long nearbyBusinessId);

}
