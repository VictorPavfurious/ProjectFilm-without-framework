package com.victorp.service;

import com.victorp.dao.UserDao;
import com.victorp.model.User;

import java.util.List;

public class GetUsersServiceImpl implements GetUsersService {
    private UserDao userDao;

    public GetUsersServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
