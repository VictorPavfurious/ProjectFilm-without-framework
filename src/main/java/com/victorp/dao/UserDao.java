package com.victorp.dao;

import com.victorp.model.User;

import java.util.List;

public interface UserDao {
     List<User> getUserbyid(Long id);
     List<User> getAllUser();

}
