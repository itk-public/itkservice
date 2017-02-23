package com.itk.base.service.impl;

import com.itk.base.mapper.PositionProvinceMapper;
import com.itk.base.model.PositionProvince;
import com.itk.base.service.PositionProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
public class PositionProvinceServiceImpl implements PositionProvinceService{

    @Autowired
    private PositionProvinceMapper provinceMapper;

    @Override
    public List<PositionProvince> selectAllProvince() {
        return provinceMapper.selectAllProvince();
    }

    @Override
    public PositionProvince selectProvinceByProvinceId(Long provinceId) {
        return provinceMapper.selectByProvinceId(provinceId);
    }
}
