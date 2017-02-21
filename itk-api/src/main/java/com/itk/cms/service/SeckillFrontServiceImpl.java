package com.itk.cms.service;

import com.itk.cms.model.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
@Service
public class SeckillFrontServiceImpl {

    @Autowired
    private SeckillService seckillService;

    public int addSeckill(Seckill seckill){
        return  seckillService.addSeckill(seckill);
    }

    public int updateSeckill(Seckill seckill){
        return  seckillService.updateSeckill(seckill);
    }

    public int delSeckill(Seckill seckill){
        return  seckillService.delSeckill(seckill);
    }

    public Seckill selectByPrimaryKey(Long id){
        return  seckillService.selectByPrimaryKey(id);
    }

    public List<Seckill> selectSeckillsByPageSortId(Long pageSortId){
        return  seckillService.selectSeckillsByPageSortId(pageSortId);
    }


}
