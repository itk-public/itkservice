package com.itk.user.service;

import com.itk.user.model.UserShippingAddress;
import com.itk.util.PageInfo;
import com.itk.util.PageParam;

/**
 * Created by young on 2017/5/17.
 */
public interface UserShippingAddressService {

    PageInfo<UserShippingAddress> getUserShippingAddress(String userId, PageParam pageParam);
}
