package com.itk.cms.service.impl;

import com.itk.cms.mapper.PartinglineMapper;
import com.itk.cms.model.Partingline;
import com.itk.cms.service.PartinglineService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
public class PartinglineServiceImpl implements PartinglineService {

    @Autowired
    private PartinglineMapper partinglineMapper;
    @Override
    public int addPartingline(Partingline partingline) {
        return partinglineMapper.insertSelective(partingline);
    }

    @Override
    public int updatePartingline(Partingline partingline) {
        return partinglineMapper.updateByPrimaryKeySelective(partingline);
    }

    @Override
    public int delPartingline(Partingline partingline) {
        return partinglineMapper.updateByPrimaryKeySelective(partingline);
    }

    @Override
    public Partingline selectByPrimaryKey(Long id) {
        return partinglineMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Partingline> selectPartinglinesByPageSortId(Long pageSortId) {
        return partinglineMapper.selectPartinglinesByPageSortId(pageSortId);
    }
}
