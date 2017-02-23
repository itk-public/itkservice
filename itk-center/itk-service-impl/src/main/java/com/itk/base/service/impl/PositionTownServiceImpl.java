package com.itk.base.service.impl;

import com.itk.base.mapper.PositionTownMapper;
import com.itk.base.model.PositionTown;
import com.itk.base.service.PositionTownService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
public class PositionTownServiceImpl implements PositionTownService{

    @Autowired
    private PositionTownMapper townMapper;

    @Override
    public List<PositionTown> selectTownByCountyId(Long countyId) {
        return townMapper.selectByCountyId(countyId);
    }

    @Override
    public PositionTown selectTownByTownId(Long townId) {
        return townMapper.selectByTownId(townId);
    }
}
