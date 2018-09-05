package com.victorp;



import com.victorp.controller.*;
import com.victorp.dao.FilmDao;
import com.victorp.dao.FilmDaoImpl;
import com.victorp.dao.UserDao;
import com.victorp.dao.UserDaoImpl;
import com.victorp.service.GetFilmsService;
import com.victorp.service.GetFilmsServiceImpl;
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

    public static GetUsersService getUsersService() {
        return new GetUsersServiceImpl(userDaoimpl());
    }

    public static UserDao userDaoimpl() {
        return new UserDaoImpl(connection);
    }

    public static GetAllFilmsController getAllFilmsController() {
        return new GetAllFilmsController(getFilmsService());
    }

    public static GetFilmsService getFilmsService() {
        return new GetFilmsServiceImpl(filmDaoImpl());
    }

    public static FilmDao filmDaoImpl() {
        return new FilmDaoImpl(connection);
    }

    public static GetFilmByIdController getFilmByIdController() {
        return new GetFilmByIdController(getFilmsService());
    }

    public static InsertFilmIntoDbController insertFilmIntoDbController() {
        return new InsertFilmIntoDbController(getFilmsService());
    }
    public static DeleteFilmController deleteFilmController() {
        return new DeleteFilmController(getFilmsService());
    }
    public static CreateUserController createUserController() {
        return new CreateUserController(getUsersService());
    }

    public static LoginUserController loginUserController() {
        return new LoginUserController(getUsersService());
    }

    public static LogOutController logOutController() {
        return new LogOutController(getUsersService());
    }


}
