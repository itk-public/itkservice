package com.itk.user.service;

import com.itk.exception.ObjectNotFoundException;
import com.itk.security.SecurityUtils;
import com.itk.user.model.UserShippingAddress;
import com.itk.user.model.UserShippingAddressExample;
import com.itk.user.model.UserShippingAddressVO;
import com.itk.user.web.mapper.UserShippingAddressMapper;
import com.itk.util.PageInfo;
import com.itk.util.PageParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    /**
     * 根据id获取收货地址详情
     *
     * @param id
     * @return
     */
    public UserShippingAddress getShippingAddressDetail(Integer id) {
        UserShippingAddress userShippingAddress = shippingAddressService.selectByPrimaryKey(id);
        if (userShippingAddress == null) {
            throw new ObjectNotFoundException(UserShippingAddress.class, id);
        }
        return userShippingAddress;
    }

    /**
     * 查询可用的收货地址详情
     *
     * @param id
     * @return
     */
    public UserShippingAddress getEnableShippingAddressDetail(Integer id) {
        UserShippingAddress userShippingAddress = shippingAddressService.selectByPrimaryKey(id);
        if (userShippingAddress != null && userShippingAddress.isEnable()) {
            return userShippingAddress;
        }
        throw new ObjectNotFoundException(UserShippingAddress.class, id);
    }

    /**
     * 获取用户默认收货地址
     *
     * @param userId
     * @return
     */
    public UserShippingAddress getUserDefaultShippingAddress(String userId) {
        return shippingAddressService.getUserDefaultShippingAddress(userId);
    }

    /**
     * 新建收货地址
     *
     * @param shippingAddressVO
     * @return
     */
    public UserShippingAddress createUserShippingAddress(UserShippingAddressVO shippingAddressVO) {
        shippingAddressVO.setId(null);
        UserShippingAddress userShippingAddress = UserShippingAddressMapper.voToModel(shippingAddressVO);
        String currentUserLogin = SecurityUtils.getCurrentUserLogin();
        Date now = new Date();
        userShippingAddress.setCreateBy(currentUserLogin);
        userShippingAddress.setCreateDate(now);
        userShippingAddress.setLastModifyBy(currentUserLogin);
        userShippingAddress.setLastModifyDate(now);
        return shippingAddressService.createUserShippingAddress(userShippingAddress);
    }

    /**
     * 修改收货地址信息(不支持逻辑删除)
     *
     * @param userShippingAddressVO
     * @return
     */
    public UserShippingAddress updateUserShippingAddress(UserShippingAddressVO userShippingAddressVO) {
        if (userShippingAddressVO.getId() == null) {
            throw new ObjectNotFoundException(UserShippingAddress.class, "");
        }
        UserShippingAddress shippingAddress = UserShippingAddressMapper.voToModel(userShippingAddressVO);
        shippingAddress.setEnable(true);
        shippingAddress.setLastModifyBy(SecurityUtils.getCurrentUserLogin());
        shippingAddress.setLastModifyDate(new Date());
        return shippingAddressService.updateUserShippingAddress(shippingAddress);
    }

    /**
     * 用户删除收货地址(enable改成false,逻辑删除)
     *
     * @param shippingAddressId
     * @return
     */
    public UserShippingAddress deleteUserShippingAddress(Integer shippingAddressId) {
        UserShippingAddress userShippingAddress = new UserShippingAddress();
        userShippingAddress.setId(shippingAddressId);
        userShippingAddress.setLastModifyBy(SecurityUtils.getCurrentUserLogin());
        userShippingAddress.setLastModifyDate(new Date());
        return shippingAddressService.deleteUserShippingAddress(userShippingAddress);
    }

    /**
     * 设置获取取消用户默认收货地址
     *
     * @param shippingAddressId
     * @param isDefault
     * @return
     */
    public UserShippingAddress setDefaultUserShippingAddress(Integer shippingAddressId, boolean isDefault) {
        UserShippingAddress existShippingAddress = getEnableShippingAddressDetail(shippingAddressId);
        existShippingAddress.setLastModifyDate(new Date());
        existShippingAddress.setLastModifyBy(SecurityUtils.getCurrentUserLogin());
        return shippingAddressService.setDefaultUserShippingAddress(existShippingAddress, isDefault);
    }
}
