package com.itk.user.web;

import com.itk.user.model.UserInfo;
import com.itk.user.service.UserInfoServiceImpl;
import com.itk.utils.DateUtils;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserInfoServiceImpl userInfoService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public WebResult registerUser(@RequestParam("phone")String phone, @RequestParam("password")String password,
                                       @RequestParam("securitycode")String securityCode) throws Exception {
        UserInfo record = new UserInfo();
        record.setUserId(UUID.randomUUID().toString());
        record.setPassword(password);
        record.setPhone(phone);
        record.setCreateDate(new Date());
        record.setLastloginDate(new Date());
        return  WebResult.ok(userInfoService.registerUser(record,securityCode));
    }

    @RequestMapping(value = "/forgetPwd", method = RequestMethod.GET)
    public WebResult forgetPwd(@RequestParam("phone")String phone, @RequestParam("password")String password,
                                               @RequestParam("securitycode")String securitycode) throws Exception {
        return  WebResult.ok(userInfoService.forgetPwd(phone,securitycode,password));
    }


    @RequestMapping(value = "/accountLogin", method = RequestMethod.GET)
    public WebResult accountLogin(@RequestParam("phone")String phone,@RequestParam("password")String password) throws Exception {
        return  WebResult.ok(userInfoService.accountLogin(phone,password));
    }

    @RequestMapping(value = "/getSecurityCode", method = RequestMethod.GET)
    public WebResult getSecurityCode(@RequestParam("phone")String phone) throws Exception {
        return  WebResult.ok(userInfoService.getSecurityCode(phone));
    }

    @RequestMapping(value = "/phoneLogin", method = RequestMethod.GET)
    public WebResult phoneLogin(@RequestParam("phone")String phone,@RequestParam("securitycode")String securitycode) throws Exception {
        return  WebResult.ok(userInfoService.phoneLogin(phone,securitycode));
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.GET)
    public WebResult updateUserInfo(@RequestParam("gender")int gender,@RequestParam("nickname")String nickName, @RequestParam("birthday")String birthday,
                                    @RequestParam(value = "email", required = false)String email) throws Exception {
        UserInfo record = new UserInfo();
        record.setGender(gender);
        record.setNickName(nickName);
        record.setEmail(email);
        record.setBirthday(DateUtils.parseDateFormat(birthday));
        return  WebResult.ok(userInfoService.updateUserInfo(record));
    }


}
