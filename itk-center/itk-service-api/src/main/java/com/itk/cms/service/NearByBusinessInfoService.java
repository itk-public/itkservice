package com.itk.cms.service;

import com.itk.cms.model.NearbyBusinessInfo;


/**
 * Created by enchen on 2/21/17.
 */
public interface NearByBusinessInfoService {

    int addNearByBusinessInfo(NearbyBusinessInfo nearbyBusinessInfo);

    int updateNearByBusinessInfo(NearbyBusinessInfo nearbyBusinessInfo);

    int delNearByBusinessInfo(Long nearbyBusinessInfoId);

    NearbyBusinessInfo selectByPrimaryKey(Long nearbyBusinessInfoId);

}
