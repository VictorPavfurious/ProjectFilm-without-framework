package com.victorp.controller;

import com.victorp.service.GetFilmsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetAllFilmsController implements Controller {

    private GetFilmsService getFilmsService;

    public GetAllFilmsController(GetFilmsService getFilmsService) {
        this.getFilmsService = getFilmsService;
    }

    @Override
    public void controller(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("films", getFilmsService.getAllFilm());
        try {
            request.getRequestDispatcher("/WEB-INF/view/getAllFilms.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
