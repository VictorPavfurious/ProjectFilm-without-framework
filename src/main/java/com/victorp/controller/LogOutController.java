package com.victorp.controller;

import com.victorp.service.GetUsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutController implements Controller {

    private GetUsersService getUsersService;

    public LogOutController(GetUsersService getUsersService) {
        this.getUsersService = getUsersService;
    }

    @Override
    public void controller(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        try {
            HttpSession session = request.getSession();
            session.removeAttribute(username);
            session.invalidate();
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
