package com.victorp.controller;

import com.victorp.model.User;
import com.victorp.service.GetUsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginUserController implements Controller {

    private GetUsersService getUsersService;

    public LoginUserController(GetUsersService getUsersService) {
        this.getUsersService = getUsersService;
    }

    @Override
    public void controller(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("username");
        String pass = request.getParameter("password");
        User user = getUsersService.validateData(email, pass);

        try {
            if (user != null) {
                Cookie cookie = new Cookie("some_id", user.getToken());
                response.addCookie(cookie);
                HttpSession session = request.getSession();
                session.setAttribute("username", user.getName());
                request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
