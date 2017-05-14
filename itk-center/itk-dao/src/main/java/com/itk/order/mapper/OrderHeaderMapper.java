package com.itk.order.mapper;

import java.util.List;

import com.itk.order.model.OrderHeader;
import com.itk.order.model.OrderHeaderExample;
import org.apache.ibatis.annotations.Param;

public interface OrderHeaderMapper {
    int countByExample(OrderHeaderExample example);

    int deleteByExample(OrderHeaderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderHeader record);

    int insertSelective(OrderHeader record);

    List<OrderHeader> selectByExample(OrderHeaderExample example);

    OrderHeader selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderHeader record, @Param("example") OrderHeaderExample example);

    int updateByExample(@Param("record") OrderHeader record, @Param("example") OrderHeaderExample example);

    int updateByPrimaryKeySelective(OrderHeader record);

    int updateByPrimaryKey(OrderHeader record);

    OrderHeader selectByOrderId(String orderId);
}