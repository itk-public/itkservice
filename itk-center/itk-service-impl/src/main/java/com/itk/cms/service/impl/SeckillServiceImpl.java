package com.itk.cms.service.impl;

import com.itk.cms.mapper.SeckillMapper;
import com.itk.cms.model.Seckill;
import com.itk.cms.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private SeckillMapper seckillMapper;

    @Override
    public int addSeckill(Seckill seckill) {
        return seckillMapper.insertSelective(seckill);
    }

    @Override
    public int updateSeckill(Seckill seckill) {
        return seckillMapper.updateByPrimaryKeySelective(seckill);
    }

    @Override
    public int delSeckill(Seckill seckill) {
        return seckillMapper.updateByPrimaryKeySelective(seckill);
    }

    @Override
    public Seckill selectByPrimaryKey(Long id) {
        return seckillMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Seckill> selectSeckillsByPageSortId(Long pageSortId) {
        return seckillMapper.selectSeckillsByPageSortId(pageSortId);
    }
}
