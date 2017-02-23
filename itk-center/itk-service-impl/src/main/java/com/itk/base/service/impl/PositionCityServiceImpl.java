package com.itk.base.service.impl;

import com.itk.base.mapper.PositionCityMapper;
import com.itk.base.model.PositionCity;
import com.itk.base.service.PositionCityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
public class PositionCityServiceImpl implements PositionCityService{

    @Autowired
    private PositionCityMapper cityMapper;

    @Override
    public List<PositionCity> selectCityByProvinceId(Long provinceId) {
        return cityMapper.selectByProvinceId(provinceId);
    }

    @Override
    public PositionCity selectCityByCityId(Long cityId) {
        return cityMapper.selectByCityId(cityId);
    }
}
