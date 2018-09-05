package com.victorp.dao;

import com.victorp.model.User;

import java.util.List;

public interface UserDao {
     User getUserById(Long id);
     User createUser(User user);
     User getUserEmailAndPassword(String email, String pass);
     User validateData(String email, String password);
     void updateUser(User user);
     User logOut(String username);

}
