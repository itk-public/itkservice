package com.itk.cms.service.impl;

import com.itk.cms.mapper.SeckillSeasonMapper;
import com.itk.cms.model.SeckillSeason;
import com.itk.cms.service.SeckillSeasonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
public class SeckillSeasonServiceImpl implements SeckillSeasonService {

    @Autowired
    private SeckillSeasonMapper seckillSeasonMapper;

    @Override
    public int addSeckillSeason(SeckillSeason seckillSeason) {
        return seckillSeasonMapper.insertSelective(seckillSeason);
    }

    @Override
    public int updateSeckillSeason(SeckillSeason seckillSeason) {
        return seckillSeasonMapper.updateByPrimaryKeySelective(seckillSeason);
    }

    @Override
    public int delSeckillSeason(SeckillSeason seckillSeason) {
        return seckillSeasonMapper.updateByPrimaryKeySelective(seckillSeason);
    }

    @Override
    public SeckillSeason selectByPrimaryKey(Long id) {
        return seckillSeasonMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SeckillSeason> selectSeckillSeasons() {
        return seckillSeasonMapper.selectSeckillSeasons();
    }
}
