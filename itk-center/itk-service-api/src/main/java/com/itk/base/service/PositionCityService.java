package com.itk.base.service;

import com.itk.base.model.PositionCity;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
public interface PositionCityService {

    List<PositionCity> selectCityByProvinceId(Integer provinceId);

    PositionCity selectCityByCityId(Long cityId);

}
