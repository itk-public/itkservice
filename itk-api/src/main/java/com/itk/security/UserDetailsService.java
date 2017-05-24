package com.itk.security;

import com.itk.user.model.UserInfo;
import com.itk.user.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UserInfoService userInfoService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);
        String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
        UserInfo userFromDatabase = userInfoService.findUserByPhone(lowercaseLogin);
        if (userFromDatabase!=null){
            return new User(lowercaseLogin,userFromDatabase.getPassword(),new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the " +
                    "database");
        }
    }
}
