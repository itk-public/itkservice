package com.itk.user.web;

import com.itk.user.model.UserInfo;
import com.itk.user.service.UserInfoFrontServiceImpl;
import com.itk.util.DateUtils;
import com.itk.util.MD5Util;
import com.itk.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoFrontServiceImpl userInfoFrontService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public WebResult registerUser(@RequestParam("phone")String phone, @RequestParam("password")String password,
                                  @RequestParam("securitycode")String securityCode) throws Exception {
        UserInfo record = new UserInfo();
        record.setUserId(UUID.randomUUID().toString());
        record.setPassword(MD5Util.stringToMD5(password));
        record.setPhone(phone);
        record.setCreateDate(new Date());
        record.setLastloginDate(new Date());
        try{
            return  WebResult.ok(userInfoFrontService.registerUser(record,securityCode));
        }catch (Exception e){
            return WebResult.ok(e.getMessage());
        }
    }

    @RequestMapping(value = "/forgetPwd", method = RequestMethod.GET)
    public WebResult forgetPwd(@RequestParam("phone")String phone, @RequestParam("password")String password,
                                               @RequestParam("securitycode")String securitycode) throws Exception {
        try{
            return  WebResult.ok(userInfoFrontService.forgetPwd(phone,securitycode,password));
        }catch (Exception e){
            return WebResult.ok(e.getMessage());
        }
    }


    @RequestMapping(value = "/accountLogin", method = RequestMethod.GET)
    public WebResult accountLogin(@RequestParam("phone")String phone,@RequestParam("password")String password) throws Exception {
        try{
            return  WebResult.ok(userInfoFrontService.accountLogin(phone,password));
        }catch (Exception e){
            return WebResult.ok(e.getMessage());
        }
    }

    @RequestMapping(value = "/getSecurityCode", method = RequestMethod.GET)
    public WebResult getSecurityCode(@RequestParam("phone")String phone) throws Exception {
        try{
            return  WebResult.ok(userInfoFrontService.getSecurityCode(phone));
        }catch (Exception e){
            return WebResult.ok(e.getMessage());
        }
    }

    @RequestMapping(value = "/phoneLogin", method = RequestMethod.GET)
    public WebResult phoneLogin(@RequestParam("phone")String phone,@RequestParam("securitycode")String securitycode) throws Exception {
        try{
            return  WebResult.ok(userInfoFrontService.phoneLogin(phone,securitycode));
        }catch (Exception e){
            return WebResult.ok(e.getMessage());
        }
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.GET)
    public WebResult updateUserInfo(@RequestParam("gender")int gender,@RequestParam("nickname")String nickName,@RequestParam("access_token")String accessToken, @RequestParam("birthday")String birthday,
                                    @RequestParam(value = "email", required = false)String email) throws Exception {
        UserInfo record = new UserInfo();
        record.setGender(gender);
        record.setNickName(nickName);
        record.setEmail(email);
        record.setBirthday(DateUtils.parseDateFormat(birthday));
        try{
            if(userInfoFrontService.updateUserInfo(record, accessToken)>0) {
                return WebResult.ok("修改密码成功！");
            }
        }catch (Exception e){
            return WebResult.ok(e.getMessage());
        }
        return WebResult.ok("修改密码失败！");
    }



    @RequestMapping(value = "/updatePassowrd", method = RequestMethod.GET)
    public WebResult updatePassowrd(@RequestParam("password")String password,@RequestParam("access_token")String accessToken) throws Exception {
        UserInfo record = new UserInfo();
        record.setPassword(MD5Util.stringToMD5(password));
        try{
            return  WebResult.ok(userInfoFrontService.updateUserInfo(record, accessToken));
        }catch (Exception e){
            return WebResult.ok(e.getMessage());
        }
    }


}
