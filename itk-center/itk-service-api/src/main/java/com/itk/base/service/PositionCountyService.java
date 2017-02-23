package com.itk.base.service;



import com.itk.base.model.PositionCounty;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
public interface PositionCountyService {

    List<PositionCounty> selectCountyByCityId(Long cityId);

    PositionCounty selectCountyByCountyId(Long county);

}
