package com.itk.cms.service.impl;

import com.itk.cms.mapper.SkuposMapper;
import com.itk.cms.model.Skupos;
import com.itk.cms.service.SkuposService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
public class SkuposServiceImpl implements SkuposService {

    @Autowired
    private SkuposMapper skuposMapper;

    @Override
    public int addSkupos(Skupos skupos) {
        return skuposMapper.insertSelective(skupos);
    }

    @Override
    public int updateSkupos(Skupos skupos) {
        return skuposMapper.updateByPrimaryKeySelective(skupos);
    }

    @Override
    public int delSkupos(Skupos skupos) {
        return skuposMapper.updateByPrimaryKeySelective(skupos);
    }

    @Override
    public Skupos selectByPrimaryKey(Long id) {
        return skuposMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Skupos> selectSkupossByPageSortId(Integer pageSortId) {
        return skuposMapper.selectSkupossByPageSortId(pageSortId);
    }
}
