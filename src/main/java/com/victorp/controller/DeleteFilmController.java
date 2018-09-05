package com.victorp.controller;

import com.victorp.service.GetFilmsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFilmController implements Controller {

    private GetFilmsService getFilmsService;

    public DeleteFilmController(GetFilmsService getFilmsService) {
        this.getFilmsService = getFilmsService;
    }

    @Override
    public void controller(HttpServletRequest request, HttpServletResponse response) {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            getFilmsService.deleteFilmById(id);
            response.sendRedirect("/servlet/success");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
