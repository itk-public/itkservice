package com.itk.base.service;

import com.itk.base.model.PositionProvince;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
public interface PositionProvinceService {

    List<PositionProvince> selectAllProvince();

    PositionProvince selectProvinceByProvinceId(Long provinceId);

}
