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
import org.springframework.transaction.annotation.Transactional;

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
        UserShippingAddressExample example = new UserShippingAddressExample();
        example.or().andUserIdEqualTo(userId).andEnableEqualTo(true).andDeefaultEqualTo(true);
        List<UserShippingAddress> shippingAddresses = shippingAddressService.selectByExample(example);
        if (shippingAddresses == null || shippingAddresses.size() < 1) {
            return null;
        } else {
            return shippingAddresses.get(0);
        }
    }

    /**
     * 新建收货地址
     *
     * @param shippingAddressVO
     * @return
     */
    public int createUserShippingAddress(UserShippingAddressVO shippingAddressVO) {
        shippingAddressVO.setId(null);
        UserShippingAddress userShippingAddress = UserShippingAddressMapper.voToModel(shippingAddressVO);
        //如果新建的为默认收货地址,将数据库中默认改成非默认
        if (userShippingAddress.isDeefault()) {
            UserShippingAddress existDefaultShippingAddress = getUserDefaultShippingAddress(userShippingAddress.getUserId());
            if (existDefaultShippingAddress != null) {
                existDefaultShippingAddress.setDeefault(false);
                shippingAddressService.updateByPrimaryKeySelective(existDefaultShippingAddress);
            }
        }
        String currentUserLogin = SecurityUtils.getCurrentUserLogin();
        Date now = new Date();
        userShippingAddress.setCreateBy(currentUserLogin);
        userShippingAddress.setCreateDate(now);
        userShippingAddress.setLastModifyBy(currentUserLogin);
        userShippingAddress.setLastModifyDate(now);
        return shippingAddressService.insertSelective(userShippingAddress);
    }

    /**
     * 修改收货地址信息(不支持修改默认,逻辑删除)
     *
     * @param userShippingAddressVO
     * @return
     */
    public int updateUserShippingAddress(UserShippingAddressVO userShippingAddressVO) {
        if (userShippingAddressVO.getId() == null) {
            throw new ObjectNotFoundException(UserShippingAddress.class, "");
        }
        UserShippingAddress existAddress = getShippingAddressDetail(userShippingAddressVO.getId());
        UserShippingAddress shippingAddress = UserShippingAddressMapper.voToModel(userShippingAddressVO);
        shippingAddress.setEnable(existAddress.isEnable());
        shippingAddress.setDeefault(existAddress.isDeefault());
        shippingAddress.setLastModifyBy(SecurityUtils.getCurrentUserLogin());
        shippingAddress.setLastModifyDate(new Date());
        return shippingAddressService.updateByPrimaryKeySelective(shippingAddress);
    }

    /**
     * 用户删除收货地址(enable改成false,逻辑删除)
     *
     * @param shippingAddressId
     * @return
     */
    public int deleteUserShippingAddress(Integer shippingAddressId) {
        UserShippingAddress userShippingAddress = new UserShippingAddress();
        userShippingAddress.setId(shippingAddressId);
        userShippingAddress.setEnable(false);
        userShippingAddress.setDeefault(false);
        userShippingAddress.setLastModifyBy(SecurityUtils.getCurrentUserLogin());
        userShippingAddress.setLastModifyDate(new Date());
        return shippingAddressService.updateByPrimaryKeySelective(userShippingAddress);
    }

    @Transactional
    public int setDefaultUserShippingAddress(Integer shippingAddressId, boolean isDefault) {
        UserShippingAddress existShippingAddress = getEnableShippingAddressDetail(shippingAddressId);
        if (isDefault) {
            UserShippingAddress existDefaultShippingAddress = getUserDefaultShippingAddress(existShippingAddress.getUserId());
            if (existDefaultShippingAddress != null) {
                existDefaultShippingAddress.setDeefault(false);
                shippingAddressService.updateByPrimaryKeySelective(existDefaultShippingAddress);
            }
        }
        existShippingAddress.setDeefault(isDefault);
        return shippingAddressService.updateByPrimaryKeySelective(existShippingAddress);
    }
}
