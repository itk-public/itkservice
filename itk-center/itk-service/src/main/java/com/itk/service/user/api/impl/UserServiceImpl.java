package com.itk.service.user.api.impl;

import com.itk.service.user.api.UserService;
import com.itk.user.mapper.UserMapper;
import com.itk.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhouhui on 2015/11/11.
 */
@Component
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(int id){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

}
