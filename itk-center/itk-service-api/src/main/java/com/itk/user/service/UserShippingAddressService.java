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

    /**
     * 获取用户收货地址(分页)
     *
     * @param userId
     * @param pageParam
     * @return
     */
    PageInfo<UserShippingAddress> getUserShippingAddress(String userId, PageParam pageParam);

    /**
     * 获取用户默认收货地址
     *
     * @param userId
     * @return
     */
    UserShippingAddress getUserDefaultShippingAddress(String userId);

    /**
     * 根据id获取收货地址详情
     *
     * @param id
     * @return
     */
    UserShippingAddress selectByPrimaryKey(Integer id);

    /**
     * 新建收货地址
     *
     * @param userShippingAddress
     * @return
     */
    UserShippingAddress createUserShippingAddress(UserShippingAddress userShippingAddress);

    /**
     * 修改收货地址
     *
     * @param userShippingAddress
     * @return
     */
    UserShippingAddress updateUserShippingAddress(UserShippingAddress userShippingAddress);


    /**
     * 删除收货地址(逻辑删除)
     *
     * @param userShippingAddress
     * @return
     */
    UserShippingAddress deleteUserShippingAddress(UserShippingAddress userShippingAddress);

    /**
     * 设置/取消默认收货地址
     *
     * @param userShippingAddress
     * @param isDefault
     * @return
     */
    UserShippingAddress setDefaultUserShippingAddress(UserShippingAddress userShippingAddress, boolean isDefault);
}
