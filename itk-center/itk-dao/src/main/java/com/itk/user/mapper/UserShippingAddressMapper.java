package com.itk.user.mapper;

import com.itk.user.model.UserShippingAddress;
import com.itk.user.model.UserShippingAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserShippingAddressMapper {
    int countByExample(UserShippingAddressExample example);

    int deleteByExample(UserShippingAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserShippingAddress record);

    int insertSelective(UserShippingAddress record);

    List<UserShippingAddress> selectByExample(UserShippingAddressExample example);

    UserShippingAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserShippingAddress record, @Param("example") UserShippingAddressExample example);

    int updateByExample(@Param("record") UserShippingAddress record, @Param("example") UserShippingAddressExample example);

    int updateByPrimaryKeySelective(UserShippingAddress record);

    int updateByPrimaryKey(UserShippingAddress record);
}