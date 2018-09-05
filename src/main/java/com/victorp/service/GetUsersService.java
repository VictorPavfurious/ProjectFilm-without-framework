package com.victorp.service;

import com.victorp.model.User;

public interface GetUsersService {
    User createUser(User user);
    User getUserEmailAndPassword(String email, String pass);
    User validateData(String email, String password);
    User logOut(String username);
}
