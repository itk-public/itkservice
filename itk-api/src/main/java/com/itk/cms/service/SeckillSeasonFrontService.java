package com.itk.cms.service;

import com.itk.cms.model.SeckillSeason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
@Service
public class SeckillSeasonFrontService {

    @Autowired
    private SeckillSeasonService seckillSeasonService;

    public int addSeckillSeason(SeckillSeason seckillSeason){
        return seckillSeasonService.addSeckillSeason(seckillSeason);
    }

    public int updateSeckillSeason(SeckillSeason seckillSeason){
        return seckillSeasonService.updateSeckillSeason(seckillSeason);
    }

    public int delSeckillSeason(SeckillSeason seckillSeason){
        return seckillSeasonService.delSeckillSeason(seckillSeason);
    }

    public SeckillSeason selectByPrimaryKey(Long id){
        return seckillSeasonService.selectByPrimaryKey(id);
    }

    public List<SeckillSeason> selectSeckillSeasons(){
        return seckillSeasonService.selectSeckillSeasons();
    }

}
