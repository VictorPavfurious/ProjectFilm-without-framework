package com.victorp.controller;

import com.victorp.model.User;
import com.victorp.service.GetUsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUserController implements Controller {

    private GetUsersService getUsersService;

    public CreateUserController(GetUsersService getUsersService) {
        this.getUsersService = getUsersService;
    }

    @Override
    public void controller(HttpServletRequest request, HttpServletResponse response) {
        User user = getCreateUser(request);
        try {
            if (!user.getEmail().isEmpty() && !user.getPassword().isEmpty() && !user.getName().isEmpty()
            && !user.getSurName().isEmpty()) {
                getUsersService.createUser(user);
                response.sendRedirect("/servlet/login");
            } else {
                response.sendRedirect("/servlet/signup");
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private User getCreateUser(HttpServletRequest request) {
        String name = request.getParameter("u_name");
        String surName = request.getParameter("u_surname");
        String email = request.getParameter("u_email");
        String password = request.getParameter("u_password");
        String token = request.getParameter("u_token");

        return new User(name, surName,email, password, token);
    }
}
