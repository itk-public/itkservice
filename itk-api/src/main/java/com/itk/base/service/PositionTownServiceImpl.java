package com.itk.base.service;

import com.itk.base.model.PositionTown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
@Service
public class PositionTownServiceImpl {

    @Autowired
    private PositionTownService townService;

    public List<PositionTown> selectTownByCountyId(Long countyId){
        return townService.selectTownByCountyId(countyId);
    }

    public PositionTown selectTownByTownId(Long townId){
        return townService.selectTownByTownId(townId);
    }
}
