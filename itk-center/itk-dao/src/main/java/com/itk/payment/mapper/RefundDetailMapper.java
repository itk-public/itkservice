package com.itk.payment.mapper;

import com.itk.payment.model.RefundDetail;
import com.itk.payment.model.RefundDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundDetailMapper {
    int countByExample(RefundDetailExample example);

    int deleteByExample(RefundDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RefundDetail record);

    Long insertSelective(RefundDetail record);

    List<RefundDetail> selectByExample(RefundDetailExample example);

    RefundDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RefundDetail record, @Param("example") RefundDetailExample example);

    int updateByExample(@Param("record") RefundDetail record, @Param("example") RefundDetailExample example);

    int updateByPrimaryKeySelective(RefundDetail record);

    int updateByPrimaryKey(RefundDetail record);
}