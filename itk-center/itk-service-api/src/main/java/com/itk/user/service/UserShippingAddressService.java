package com.itk.user.service;

import com.itk.user.model.UserShippingAddress;
import com.itk.user.model.UserShippingAddressExample;
import com.itk.util.PageInfo;
import com.itk.util.PageParam;

import java.util.List;

/**
 * Created by young on 2017/5/17.
 */
public interface UserShippingAddressService {

    PageInfo<UserShippingAddress> getUserShippingAddress(String userId, PageParam pageParam);

    UserShippingAddress selectByPrimaryKey(Integer id);

    int insertSelective(UserShippingAddress shippingAddress);

    int updateByPrimaryKeySelective(UserShippingAddress record);

    int updateByPrimaryKey(UserShippingAddress record);

    List<UserShippingAddress> selectByExample(UserShippingAddressExample shippingAddress);
}
