package com.itk.cms.mapper;

import com.itk.cms.model.Seckill;
import com.itk.cms.model.SeckillExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeckillMapper {
    int countByExample(SeckillExample example);

    int deleteByExample(SeckillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Seckill record);

    int insertSelective(Seckill record);

    List<Seckill> selectByExample(SeckillExample example);

    Seckill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Seckill record, @Param("example") SeckillExample example);

    int updateByExample(@Param("record") Seckill record, @Param("example") SeckillExample example);

    int updateByPrimaryKeySelective(Seckill record);

    int updateByPrimaryKey(Seckill record);

    List<Seckill> selectSeckillsByPageSortId(Integer pageSortId);
}