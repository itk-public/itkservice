package com.itk.cms.service;

import com.itk.cms.model.NearbyBusinessInfo;

/**
 * Created by zhouhui on 2017/3/3.
 */
public interface NearbyBusinessInfoService {

    int addNearbyBusinessInfo(NearbyBusinessInfo nearbyBusinessInfo);

    int updateNearbyBusinessInfo(NearbyBusinessInfo nearbyBusinessInfo);

    int deleNearbyBusinessInfo(NearbyBusinessInfo NearbyBusinessInfo);

    NearbyBusinessInfo selectByPrimaryKey(Long id);

    NearbyBusinessInfo selectNearbyBusinessInfosByNearbyBusinessId(Long nearByBusinessId);
}
