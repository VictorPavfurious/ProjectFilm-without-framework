package com.victorp.dao;

import com.victorp.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> getUserbyid(Long id) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList =  new ArrayList<>();
        String sql = "SELECT ID, NAME, SURNAME FROM USERS";

        Statement statement = null;
        ResultSet resultSet = null;

        try {
           statement = connection.createStatement();
           resultSet = statement.executeQuery(sql);

          while (resultSet.next()) {
          userList.add(new User(resultSet.getLong(1),
                   resultSet.getString(2),
                   resultSet.getString(3)));
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
