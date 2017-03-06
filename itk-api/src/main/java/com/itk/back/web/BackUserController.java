package com.itk.back.web;

import com.itk.back.model.BackUser;
import com.itk.back.service.BackUserFrontServiceImpl;
import com.itk.utils.MD5Util;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by zhouhui on 2017/3/5.
 */
@RestController
@RequestMapping("/back/backuser")
public class BackUserController {
    @Autowired
    private BackUserFrontServiceImpl backUserFrontService;

    @RequestMapping(value = "/addBackUser", method = RequestMethod.GET)
    public WebResult addBackUser(@RequestParam("username")String username, @RequestParam("name")String name,
                                 @RequestParam("phone")String phone, @RequestParam("password")String password,
                                 @RequestParam("email")String email) throws Exception {
        BackUser backUser = new BackUser();
        backUser.setName(name);
        backUser.setUsername(username);
        backUser.setIsDel(0);
        backUser.setCreateDate(new Date());
        backUser.setPassword(MD5Util.stringToMD5(password));
        backUser.setPhone(phone);
        backUser.setEmail(email);
        backUser.setLastloginDate(new Date());
        if(backUserFrontService.addBackUser(backUser) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/updateBackUser/{id}", method = RequestMethod.GET)
    public WebResult updateBackUser(@PathVariable(value = "id") int id,
                                    @RequestParam("username")String username, @RequestParam("name")String name,
                                    @RequestParam("phone")String phone, @RequestParam("password")String password,
                                    @RequestParam("email")String email) throws Exception {
        BackUser backUser = new BackUser();
        backUser.setId(id);
        backUser.setName(name);
        backUser.setUsername(username);
        backUser.setPassword(MD5Util.stringToMD5(password));
        backUser.setPhone(phone);
        backUser.setEmail(email);
        if(backUserFrontService.updateByPrimaryKeySelective(backUser) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/delBackUser/{id}", method = RequestMethod.GET)
    public WebResult delBackUser(@PathVariable(value = "id") int id) throws Exception {
        BackUser backUser = new BackUser();
        backUser.setId(id);
        backUser.setIsDel(1);
        if(backUserFrontService.updateByPrimaryKeySelective(backUser) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/queryBackUser/{id}", method = RequestMethod.GET)
    public WebResult queryBackUser(@PathVariable(value = "id") int id) throws Exception {
        return WebResult.ok(backUserFrontService.selectByPrimaryKey(id));
    }


    @RequestMapping(value = "/selectAllBackUsers", method = RequestMethod.GET)
    public WebResult selectAllBackUsers() throws Exception {
        return WebResult.ok(backUserFrontService.selectAllUsers());
    }


}
