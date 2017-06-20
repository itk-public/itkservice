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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by young on 2017/5/17.
 */
public class UserShippingAddressServiceImpl implements UserShippingAddressService {

    @Autowired
    UserShippingAddressMapper shippingAddressMapper;

    @Override
    public PageInfo<UserShippingAddress> getUserShippingAddress(String userId, PageParam pageParam) {
        UserShippingAddressExample example = new UserShippingAddressExample();
        example.or().andUserIdEqualTo(userId).andEnableEqualTo(true);
        PageHelper.startPage(pageParam);
        Page<UserShippingAddress> page = (Page<UserShippingAddress>) shippingAddressMapper.selectByExample(example);
        return new PageInfo<>(page);
    }

    @Override
    public UserShippingAddress selectByPrimaryKey(Integer id) {
        return shippingAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserShippingAddress getUserDefaultShippingAddress(String userId) {
        UserShippingAddressExample example = new UserShippingAddressExample();
        example.or().andUserIdEqualTo(userId).andEnableEqualTo(true).andDeefaultEqualTo(true);
        List<UserShippingAddress> shippingAddresses = shippingAddressMapper.selectByExample(example);
        if (shippingAddresses == null || shippingAddresses.size() < 1) {
            return null;
        } else {
            return shippingAddresses.get(0);
        }
    }

    @Transactional
    @Override
    public UserShippingAddress createUserShippingAddress(UserShippingAddress userShippingAddress) {
        //如果新建的为默认收货地址,将数据库中默认改成非默认
        if (userShippingAddress.isDeefault()) {
            UserShippingAddress existDefaultShippingAddress = getUserDefaultShippingAddress(userShippingAddress.getUserId());
            //将数据库中默认改为非默认
            if (existDefaultShippingAddress != null) {
                existDefaultShippingAddress.setLastModifyBy(userShippingAddress.getCreateBy());
                existDefaultShippingAddress.setLastModifyDate(userShippingAddress.getCreateDate());
                setDefaultUserShippingAddress(existDefaultShippingAddress, false);
            }
        }
        shippingAddressMapper.insertSelective(userShippingAddress);
        return userShippingAddress;
    }

    @Transactional
    @Override
    public UserShippingAddress updateUserShippingAddress(UserShippingAddress userShippingAddress) {
        UserShippingAddress existShippingAddress = shippingAddressMapper.selectByPrimaryKey(userShippingAddress.getId());
        if (!existShippingAddress.isDeefault() && userShippingAddress.isDeefault()) {
            //修改非默认为默认,需将数据库中默认改为非默认
            UserShippingAddress userDefaultShippingAddress = getUserDefaultShippingAddress(userShippingAddress.getUserId());
            if (userDefaultShippingAddress != null) {
                userDefaultShippingAddress.setLastModifyBy(userShippingAddress.getLastModifyBy());
                userDefaultShippingAddress.setLastModifyDate(userShippingAddress.getLastModifyDate());
                setDefaultUserShippingAddress(userDefaultShippingAddress, false);
            }
        }
        shippingAddressMapper.updateByPrimaryKeySelective(userShippingAddress);
        UserShippingAddress updateShippingAddress = shippingAddressMapper.selectByPrimaryKey(userShippingAddress.getId());
        return updateShippingAddress;
    }

    @Override
    public UserShippingAddress deleteUserShippingAddress(UserShippingAddress userShippingAddress) {
        if (userShippingAddress.getId() == null) {
            throw new RuntimeException("userShippingAddressId can't be null ");
        }
        userShippingAddress.setEnable(false);
        userShippingAddress.setDeefault(false);
        shippingAddressMapper.updateByPrimaryKeySelective(userShippingAddress);
        return userShippingAddress;
    }

    @Override
    public UserShippingAddress setDefaultUserShippingAddress(UserShippingAddress userShippingAddress, boolean isDefault) {
        if (isDefault) {
            //设为默认时将数据库中默认改为非默认
            UserShippingAddress existDefaultShippingAddress = getUserDefaultShippingAddress(userShippingAddress.getUserId());
            if (existDefaultShippingAddress != null) {
                existDefaultShippingAddress.setLastModifyBy(userShippingAddress.getLastModifyBy());
                existDefaultShippingAddress.setLastModifyDate(userShippingAddress.getLastModifyDate());
                setDefaultUserShippingAddress(existDefaultShippingAddress, false);
            }
        }
        userShippingAddress.setDeefault(isDefault);
        shippingAddressMapper.updateByPrimaryKeySelective(userShippingAddress);
        return userShippingAddress;
    }
}
