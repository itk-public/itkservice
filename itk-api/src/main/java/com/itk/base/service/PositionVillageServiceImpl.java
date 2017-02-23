package com.itk.base.service;

import com.itk.base.model.PositionVillage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
@Service
public class PositionVillageServiceImpl {

    @Autowired
    private PositionVillageService villageService;

    public List<PositionVillage> selectVillageByTownId(Long townId){
        return villageService.selectVillageByTownId(townId);
    }

    public PositionVillage selectVillageByVillageId(Long villageId){
        return villageService.selectVillageByVillageId(villageId);
    }
}
