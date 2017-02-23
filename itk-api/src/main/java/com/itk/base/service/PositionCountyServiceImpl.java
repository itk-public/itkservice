package com.itk.base.service;

import com.itk.base.model.PositionCounty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
@Service
public class PositionCountyServiceImpl {

    @Autowired
    private PositionCountyService countyService;

    public List<PositionCounty> selectCountyByCityId(Long cityId){
        return countyService.selectCountyByCityId(cityId);
    }

    public PositionCounty selectCountyByCountyId(Long countyId){
        return countyService.selectCountyByCountyId(countyId);
    }
}
