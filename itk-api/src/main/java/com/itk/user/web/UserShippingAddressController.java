package com.itk.user.web;

import com.itk.security.SecurityUtils;
import com.itk.user.model.UserShippingAddress;
import com.itk.user.model.UserShippingAddressVO;
import com.itk.user.service.UserShippingAddressFrontService;
import com.itk.util.PageInfo;
import com.itk.utils.PaginationUtil;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

/**
 * Created by young on 2017/5/17.
 */
@RestController
@RequestMapping(value = "/api/user/shipping/address")
public class UserShippingAddressController {

    @Autowired
    UserShippingAddressFrontService shippingAddressFrontService;

    /**
     * 获取用户可用的收货地址列表,分页
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUserShippingAddress(@RequestParam(required = false) Integer pageNum,
                                                    @RequestParam(required = false) Integer pageSize) throws URISyntaxException{

        PageInfo<UserShippingAddress> page = shippingAddressFrontService.getUserShippingAddress(SecurityUtils.getCurrentUserLogin(), pageNum, pageSize);
        HttpHeaders httpHeaders = PaginationUtil.generatePaginationHttpHeaders(page,"/api/user/shipping/address");
        return new ResponseEntity<>(WebResult.ok(page.getResult()),httpHeaders, HttpStatus.OK);
    }

    /**
     * 获取用户收货地址id
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserShippingAddressDetail(@PathVariable Integer id) {
        return null;
    }

    /**
     * 新增用户收货地址
     *
     * @param shippingAddressVO
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createUserShippingAddress(@RequestBody UserShippingAddressVO shippingAddressVO) {
        return null;
    }

    /**
     * 修改用户收货地址
     *
     * @param shippingAddressVO
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateUserShippingAddress(@RequestBody UserShippingAddressVO shippingAddressVO) {
        return null;
    }

    /**
     * 删除用户收货地址
     *
     * @param shippingAddressId
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserShippingAddress(@RequestParam Integer shippingAddressId) {
        return ResponseEntity.ok().body(null);
    }
}
