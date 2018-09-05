package com.victorp.controller;

import com.victorp.model.Film;
import com.victorp.service.GetFilmsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertFilmIntoDbController implements Controller {

    private GetFilmsService getFilmsService;

    public InsertFilmIntoDbController(GetFilmsService getFilmsService) {
        this.getFilmsService = getFilmsService;
    }

    @Override
    public void controller(HttpServletRequest request, HttpServletResponse response) {

        Film film = getFilm(request);
        getFilmsService.insertFilm(film);
        try {
            response.sendRedirect("/servlet/success");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Film getFilm(HttpServletRequest request) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        return new Film(title, description);
    }
}
