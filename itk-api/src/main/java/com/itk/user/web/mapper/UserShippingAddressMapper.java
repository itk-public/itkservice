package com.itk.user.web.mapper;

import com.itk.user.model.UserShippingAddress;
import com.itk.user.model.UserShippingAddressVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by young on 2017/5/21.
 */
public class UserShippingAddressMapper {

    public static UserShippingAddress voToModel(UserShippingAddressVO userShippingAddressVO) {
        UserShippingAddress userShippingAddress = new UserShippingAddress();
        if (userShippingAddressVO != null) {
            BeanUtils.copyProperties(userShippingAddressVO, userShippingAddress);
        }
        return userShippingAddress;
    }


    public static UserShippingAddressVO modelToVO(UserShippingAddress userShippingAddress) {
        UserShippingAddressVO userShippingAddressVO = new UserShippingAddressVO();
        if (userShippingAddress != null) {
            BeanUtils.copyProperties(userShippingAddress, userShippingAddressVO);
        }
        return userShippingAddressVO;
    }
}
