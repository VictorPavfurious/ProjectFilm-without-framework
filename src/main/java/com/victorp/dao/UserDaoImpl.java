package com.victorp.dao;

import com.victorp.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User createUser(User user) {
        String sql = "INSERT INTO USERS (NAME, SURNAME, EMAIL, PASSWORD, TOKEN)" +
                "VALUES(?,?,?,?,?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getToken());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserEmailAndPassword(String email, String pass) {
        String sql = "SELECT ID, NAME, SURNAME, EMAIL, PASSWORD, TOKEN" +
                " FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, pass);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
               user = new User(resultSet.getLong(1),
                       resultSet.getString(2),
                       resultSet.getString(3),
                       resultSet.getString(4),
                       resultSet.getString(5),
                       resultSet.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User validateData(String email, String password) {
        return null;
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE USERS SET NAME = ?, SURNAME = ?, EMAIL = ?, PASSWORD = ?, TOKEN = ?" +
                "WHERE ID = ?";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setString(5, user.getToken());
            preparedStatement.setLong(6, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User logOut(String username) {
        return null;
    }
}
