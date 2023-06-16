/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.serviceimpl;

import com.testmart.model.User;
import com.testmart.model.Users;
import com.testmart.service.UserService;
import com.testmart.util.JacksonReaderUtil;
import com.testmart.util.OkHttpClientUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.testmart.constant.CommonConstants.*;

import java.util.Collections;
import java.util.List;

/**
 * @author Ravi Jiyani
 * @since 1.0.0
 */
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LogManager.getLogger();

    @Override
    public List<User> getAllUsers() {
        LOG.debug("getAllUsers() called");
        String response = OkHttpClientUtil.getHttpRequest(USERS_RESOURCE);
        Users users = JacksonReaderUtil.getObject(response, Users.class);
        return (users!=null)? users.getUsers(): Collections.emptyList();
    }

    @Override
    public User getUser(Integer userId) {
        LOG.debug("getUser() called with userId={}", userId);
        String response = OkHttpClientUtil.getHttpRequest(USERS_RESOURCE+"/"+userId);
        User user = JacksonReaderUtil.getObject(response, User.class);
        return user;
    }

    @Override
    public List<User> searchUsers(String query) {
        LOG.debug("searchUsers() called with query={}", query);
        String response = OkHttpClientUtil.getHttpRequest(USERS_RESOURCE+"/search?q="+query);
        Users users = JacksonReaderUtil.getObject(response, Users.class);
        return (users!=null)? users.getUsers(): Collections.emptyList();
    }
}
