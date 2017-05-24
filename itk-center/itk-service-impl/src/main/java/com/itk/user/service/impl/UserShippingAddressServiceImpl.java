package com.itk.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itk.user.mapper.UserShippingAddressMapper;
import com.itk.user.model.UserShippingAddress;
import com.itk.user.model.UserShippingAddressExample;
import com.itk.user.service.UserShippingAddressService;
import com.itk.util.PageInfo;
import com.itk.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by young on 2017/5/17.
 */
public class UserShippingAddressServiceImpl implements UserShippingAddressService {

    @Autowired
    UserShippingAddressMapper shippingAddressMapper;

    @Override
    public PageInfo<UserShippingAddress> getUserShippingAddress(String userId, PageParam pageParam) {
        UserShippingAddressExample example = new UserShippingAddressExample();
        example.or().andUserIdEqualTo(userId);
        PageHelper.startPage(pageParam);
        Page<UserShippingAddress> page = (Page<UserShippingAddress>) shippingAddressMapper.selectByExample(example);
        return new PageInfo<>(page);
    }
}
