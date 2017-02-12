package com.itk.user.web;

import com.itk.service.user.api.UserService;
import com.itk.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public int registerUser(@RequestParam("username")String username, @RequestParam("password")String password,
                            @RequestParam("phone")String phone
                            ) {
        User user = new User();
        user.setName("中文");
        return  userService.insert(user);
    }


    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    public User selectById(@RequestParam("id")int id) {
        return  userService.selectUser(id);
    }


}
