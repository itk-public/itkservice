package com.itk.base.service.impl;

import com.itk.base.mapper.PositionVillageMapper;
import com.itk.base.model.PositionVillage;
import com.itk.base.service.PositionVillageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
public class PositionVillageServiceImpl implements PositionVillageService{

    @Autowired
    private PositionVillageMapper villageMapper;

    @Override
    public List<PositionVillage> selectVillageByTownId(Long townID) {
        return villageMapper.selectByTownId(townID);
    }

    @Override
    public PositionVillage selectVillageByVillageId(Long villageId) {
        return villageMapper.selectByVillageId(villageId);
    }
}
