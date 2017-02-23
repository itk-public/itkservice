package com.itk.base.service.impl;

import com.itk.base.mapper.PositionCountyMapper;
import com.itk.base.model.PositionCounty;
import com.itk.base.service.PositionCountyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
public class PositionCountyServiceImpl implements PositionCountyService{

    @Autowired
    private PositionCountyMapper countyMapper;

    @Override
    public List<PositionCounty> selectCountyByCityId(Long cityId) {
        return countyMapper.selectByCityId(cityId);
    }

    @Override
    public PositionCounty selectCountyByCountyId(Long countyId) {
        return countyMapper.selectByCountyId(countyId);
    }
}
