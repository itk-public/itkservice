package com.itk.payment.mapper;

import com.itk.payment.model.RefundFlow;
import com.itk.payment.model.RefundFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundFlowMapper {
    int countByExample(RefundFlowExample example);

    int deleteByExample(RefundFlowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RefundFlow record);

    Long insertSelective(RefundFlow record);

    List<RefundFlow> selectByExample(RefundFlowExample example);

    RefundFlow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RefundFlow record, @Param("example") RefundFlowExample example);

    int updateByExample(@Param("record") RefundFlow record, @Param("example") RefundFlowExample example);

    int updateByPrimaryKeySelective(RefundFlow record);

    int updateByPrimaryKey(RefundFlow record);
}