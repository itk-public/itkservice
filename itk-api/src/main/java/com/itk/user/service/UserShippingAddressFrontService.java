package com.itk.user.service;

import com.itk.user.model.UserShippingAddress;
import com.itk.util.PageInfo;
import com.itk.util.PageParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by young on 2017/5/17.
 */
@Service
public class UserShippingAddressFrontService {

    private final static Logger log = LoggerFactory.getLogger(UserShippingAddressFrontService.class);

    @Autowired
    UserShippingAddressService shippingAddressService;

    /**
     * 获取用户收货地址(分页)
     *
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<UserShippingAddress> getUserShippingAddress(String userId, Integer pageNum, Integer pageSize) {
        return shippingAddressService.getUserShippingAddress(userId, PageParam.builder().pageNum(pageNum == null || pageNum == 0 ? 1 : pageNum).pageSize(pageSize == null || pageSize == 0 ? 1 : pageSize).count(true).orderBy("deefault desc").build());
    }
}
