package com.itk.user.web;

import com.itk.util.*;
import com.itk.security.SecurityUtils;
import com.itk.user.model.UserShippingAddress;
import com.itk.user.model.UserShippingAddressVO;
import com.itk.user.service.UserShippingAddressFrontService;
import com.itk.user.web.mapper.UserShippingAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

/**
 * Created by young on 2017/5/17.
 */
@RestController
@RequestMapping(value = "/api/user/shipping/address")
public class UserShippingAddressController {

    @Autowired
    UserShippingAddressFrontService shippingAddressFrontService;

    @Autowired
    MessageSource exceptionSource;

    /**
     * 获取用户可用的收货地址列表,分页
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUserShippingAddress(@RequestParam(required = false) Integer pageNum,
                                                    @RequestParam(required = false) Integer pageSize) throws URISyntaxException {

        PageInfo<UserShippingAddress> page = shippingAddressFrontService.getUserShippingAddress(SecurityUtils.getCurrentUserLogin(), pageNum, pageSize);
        HttpHeaders httpHeaders = PaginationUtil.generatePaginationHttpHeaders(page, "/api/user/shipping/address");
        return new ResponseEntity<>(
                WebResult.ok(
                        page.getResult().stream()
                                .map(UserShippingAddressMapper::modelToVO).collect(Collectors.toList())),
                httpHeaders,
                HttpStatus.OK);
    }

    /**
     * 获取用户收货地址详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserShippingAddressDetail(@PathVariable Integer id) {
        return ResponseEntity.ok(
                WebResult.ok(
                        UserShippingAddressMapper.modelToVO(shippingAddressFrontService.getShippingAddressDetail(id))
                )
        );
    }

    /**
     * 获取用户默认收货地址
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public ResponseEntity<?> getUserDefaultShippingAddress(@RequestParam String userId) {
        return ResponseEntity.ok(
                WebResult.ok(
                        UserShippingAddressMapper.modelToVO(
                                shippingAddressFrontService.getUserDefaultShippingAddress(userId)
                        )
                )
        );
    }

    /**
     * 新增用户收货地址
     *
     * @param shippingAddressVO
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createUserShippingAddress(@Valid @RequestBody UserShippingAddressVO shippingAddressVO) {
        shippingAddressFrontService.createUserShippingAddress(shippingAddressVO);
        return ResponseEntity.ok(
                WebResult.ok(
                        exceptionSource.getMessage(ResultCode.ADD_SUCCESS + "", new String[]{}, "SUCCESS", LocaleLanguageUtil.DEFAULT_LOCALE)
                )
        );
    }

    /**
     * 修改用户收货地址
     *
     * @param shippingAddressVO
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateUserShippingAddress(@RequestBody UserShippingAddressVO shippingAddressVO) {
        shippingAddressFrontService.updateUserShippingAddress(shippingAddressVO);
        return ResponseEntity.ok(
                WebResult.ok(
                        exceptionSource.getMessage(ResultCode.EDIT_SUCCESS + "", new String[]{}, "SUCCESS", LocaleLanguageUtil.DEFAULT_LOCALE)
                )
        );
    }

    /**
     * 删除用户收货地址
     *
     * @param shippingAddressId
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserShippingAddress(@RequestParam Integer shippingAddressId) {
        shippingAddressFrontService.deleteUserShippingAddress(shippingAddressId);
        return ResponseEntity.ok(
                WebResult.ok(
                        exceptionSource.getMessage(ResultCode.DELETE_SUCCESS + "", new String[]{}, "SUCCESS", LocaleLanguageUtil.DEFAULT_LOCALE)
                )
        );
    }

    /**
     * 设置默认收货地址
     *
     * @param shippingAddressId
     * @param isDefault
     * @return
     */
    @RequestMapping(value = "/setDefault", method = RequestMethod.POST)
    public ResponseEntity<?> setDefaultShippingAddress(@RequestParam Integer shippingAddressId,
                                                       @RequestParam boolean isDefault) {
        shippingAddressFrontService.setDefaultUserShippingAddress(shippingAddressId, isDefault);
        return ResponseEntity.ok(
                WebResult.ok(
                        exceptionSource.getMessage(ResultCode.EDIT_SUCCESS + "", null, "SUCCESS", LocaleLanguageUtil.DEFAULT_LOCALE)
                )
        );
    }
}
