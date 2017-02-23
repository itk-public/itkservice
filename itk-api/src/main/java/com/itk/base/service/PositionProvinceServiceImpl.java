package com.itk.base.service;

import com.itk.base.model.PositionProvince;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
@Service
public class PositionProvinceServiceImpl {

    @Autowired
    private PositionProvinceService provinceService;

    public List<PositionProvince> selectAllProvince(){
        return provinceService.selectAllProvince();
    }

    public PositionProvince selectProvinceByProvinceId(Long provinceId){
        return provinceService.selectProvinceByProvinceId(provinceId);
    }
}
