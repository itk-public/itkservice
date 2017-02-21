package com.itk.cms.service.impl;

import com.itk.cms.mapper.JewelMapper;
import com.itk.cms.model.Jewel;
import com.itk.cms.service.JewelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
public class JewelServiceImpl implements JewelService {

    @Autowired
    private JewelMapper jewelMapper;

    @Override
    public int addJewel(Jewel jewel) {
        return jewelMapper.insertSelective(jewel);
    }

    @Override
    public int updateJewel(Jewel jewel) {
        return jewelMapper.updateByPrimaryKey(jewel);
    }

    @Override
    public int deleJewel(Jewel jewel) {
        return jewelMapper.updateByPrimaryKey(jewel);
    }

    @Override
    public Jewel selectByPrimaryKey(Long id) {
        return jewelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Jewel> selectJewelsByPageSortId(Long pageSortId) {
        return jewelMapper.selectJewelsByPageSortId(pageSortId);
    }
}
