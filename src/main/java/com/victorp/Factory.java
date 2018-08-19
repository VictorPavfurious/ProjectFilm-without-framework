package com.victorp;



import com.victorp.controller.GetAllUsersController;
import com.victorp.dao.UserDao;
import com.victorp.dao.UserDaoImpl;
import com.victorp.service.GetUsersService;
import com.victorp.service.GetUsersServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;

public class Factory {
    private static Connection connection;
    static {
        try{
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test",
                    "sa",
                    "");

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static GetAllUsersController getAllUsersController() {
        return new GetAllUsersController (getUsersService());
    }
    public static GetUsersService getUsersService() {
        return new GetUsersServiceImpl(userDao());
    }
    public static UserDao userDao() {
        return new UserDaoImpl(connection);
    }
}
