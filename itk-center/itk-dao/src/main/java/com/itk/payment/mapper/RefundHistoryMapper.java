package com.itk.payment.mapper;

import com.itk.payment.model.RefundHistory;
import com.itk.payment.model.RefundHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundHistoryMapper {
    int countByExample(RefundHistoryExample example);

    int deleteByExample(RefundHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RefundHistory record);

    int insertSelective(RefundHistory record);

    List<RefundHistory> selectByExample(RefundHistoryExample example);

    RefundHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RefundHistory record, @Param("example") RefundHistoryExample example);

    int updateByExample(@Param("record") RefundHistory record, @Param("example") RefundHistoryExample example);

    int updateByPrimaryKeySelective(RefundHistory record);

    int updateByPrimaryKey(RefundHistory record);
}