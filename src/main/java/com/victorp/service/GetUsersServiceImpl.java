package com.victorp.service;

import com.victorp.dao.UserDao;
import com.victorp.model.User;

import java.util.UUID;

public class GetUsersServiceImpl implements GetUsersService {
    private UserDao userDao;

    public GetUsersServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User createUser(User user) {
        user.setToken(generateToken());
        return userDao.createUser(user);
    }

    @Override
    public User getUserEmailAndPassword(String email, String pass) {
        return userDao.getUserEmailAndPassword(email, pass);
    }

    @Override
    public User validateData(String email, String password) {
        User user = getUserEmailAndPassword(email, password);

        if (user != null && user.getPassword().equals(password)) {
            user.setToken(generateToken());
            userDao.updateUser(user);
        }
        return user;
    }

    @Override
    public User logOut(String username) {
        return userDao.logOut(username);
    }

    public String generateToken() {
        return UUID.randomUUID().toString();
    }
}
