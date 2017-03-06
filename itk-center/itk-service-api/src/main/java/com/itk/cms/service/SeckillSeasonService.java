package com.itk.cms.service;

import com.itk.cms.model.SeckillSeason;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
public interface SeckillSeasonService {

    int addSeckillSeason(SeckillSeason seckillSeason);

    int updateSeckillSeason(SeckillSeason seckillSeason);

    int delSeckillSeason(SeckillSeason seckillSeason);

    SeckillSeason selectByPrimaryKey(Long id);

    List<SeckillSeason> selectSeckillSeasons();
}
