package com.itk.back.web;

import com.itk.back.model.BackUser;
import com.itk.back.service.BackUserFrontServiceImpl;
import com.itk.utils.MD5Util;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by zhouhui on 2017/3/5.
 */
@RestController
@RequestMapping("/back/backuser")
public class BackUserController {
    @Autowired
    private BackUserFrontServiceImpl backUserFrontService;

    @RequestMapping(value = "/addBackUser", method = RequestMethod.POST)
    public WebResult addBackUser(@RequestBody BackUser backUser) {
        if(backUserFrontService.addBackUser(backUser) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/updateBackUser", method = RequestMethod.POST)
    public WebResult updateBackUser(@RequestBody BackUser backUser) throws Exception {
        if(backUserFrontService.updateByPrimaryKeySelective(backUser) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/delBackUser/{id}", method = RequestMethod.DELETE)
    public WebResult delBackUser(@PathVariable(value = "id") int id) throws Exception {
        BackUser backUser = new BackUser();
        backUser.setId(id);
        backUser.setIsDel(1);
        if(backUserFrontService.updateByPrimaryKeySelective(backUser) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }

    @RequestMapping(value = "/queryBackUser/{id}", method = RequestMethod.GET)
    public WebResult queryBackUser(@PathVariable(value = "id") int id) throws Exception {
        return WebResult.ok(backUserFrontService.selectByPrimaryKey(id));
    }


    @RequestMapping(value = "/loginBackUser", method = RequestMethod.GET)
    public WebResult loginBackUser(@RequestParam(value = "username") String username, @RequestParam("password")String password) throws Exception {
        BackUser backUser = new BackUser();
        backUser.setUsername(username);
        backUser.setPassword(MD5Util.stringToMD5(password));
        return WebResult.ok(backUserFrontService.loginBackUser(backUser));
    }


    @RequestMapping(value = "/selectAllBackUsers", method = RequestMethod.GET)
    public WebResult selectAllBackUsers() throws Exception {
        return WebResult.ok(backUserFrontService.selectAllUsers());
    }

    @RequestMapping(value = "/usernameIsExist", method = RequestMethod.GET)
    public WebResult usernameIsExist(@RequestParam String username) throws Exception {
        return WebResult.ok(backUserFrontService.usernameIsExist(username));
    }

    @RequestMapping(value = "/emailIsExist", method = RequestMethod.GET)
    public WebResult emailIsExist(@RequestParam String email) throws Exception {
        return WebResult.ok(backUserFrontService.emailIsExist(email));
    }

    @RequestMapping(value = "/phoneIsExist", method = RequestMethod.GET)
    public WebResult phoneIsExist(@RequestParam String phone) throws Exception {
        return WebResult.ok(backUserFrontService.phoneIsExist(phone));
    }
}
