package com.victorp.controller;

import com.victorp.service.GetUsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAllUsersController implements Controller {

    private GetUsersService getUsersService;

    public GetAllUsersController(GetUsersService getUsersService) {
        this.getUsersService = getUsersService;
    }

    @Override
    public void controller(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("users", getUsersService.getAllUser());
        try {
            request.getRequestDispatcher("/WEB-INF/view/getUsers.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
