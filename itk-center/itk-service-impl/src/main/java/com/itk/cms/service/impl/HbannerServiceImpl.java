package com.itk.cms.service.impl;

import com.itk.cms.mapper.HbannerMapper;
import com.itk.cms.model.Hbanner;
import com.itk.cms.service.HbannerService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by enchen on 2/21/17.
 */
public class HbannerServiceImpl implements HbannerService {

    @Autowired
    private HbannerMapper hbannerMapper;


    @Override
    public int addHbanner(Hbanner hbanner) {
        return hbannerMapper.insertSelective(hbanner);
    }

    @Override
    public int updateHbanner(Hbanner hbanner) {
        return hbannerMapper.updateByPrimaryKeySelective(hbanner);
    }

    @Override
    public int delHbanner(Long hbannerID) {
        Hbanner hbanner = hbannerMapper.selectByPrimaryKey(hbannerID);
        hbanner.setIsDel(1);// isDel 0: 可用  1: 已删除
        return hbannerMapper.updateByPrimaryKeySelective(hbanner);
    }

    @Override
    public Hbanner selectByPrimaryKey(Long hbannerID) {
        return hbannerMapper.selectByPrimaryKey(hbannerID);
    }

    @Override
    public List<Hbanner> selectHbannersByPageSortId(Long pageSortId) {
        return hbannerMapper.selectHbannersByPageSortId(pageSortId);
    }


}
