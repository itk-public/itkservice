package com.itk.service.user.api;

import com.itk.user.model.User;

/**
 * Created by zhouhui on 2015/12/28.
 */
public interface UserService {

    User selectUser(int id);

    int insert(User record);

}
