package com.itk.base.service;

import com.itk.base.model.PositionCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
@Service
public class PositionCityServiceImpl {

    @Autowired
    private PositionCityService cityService;

    public List<PositionCity> selectCityByProvinceId(Long provinceId){
        return cityService.selectCityByProvinceId(provinceId);
    }

    public PositionCity selectCityByCityId(Long cityId){
        return cityService.selectCityByCityId(cityId);
    }
}
