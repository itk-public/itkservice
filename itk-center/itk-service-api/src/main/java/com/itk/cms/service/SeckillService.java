package com.itk.cms.service;

import com.itk.cms.model.Seckill;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
public interface SeckillService {

    int addSeckill(Seckill seckill);

    int updateSeckill(Seckill seckill);

    int delSeckill(Seckill seckill);

    Seckill selectByPrimaryKey(Long id);

    List<Seckill> selectSeckillsByPageSortId(Long pageSortId);
}
