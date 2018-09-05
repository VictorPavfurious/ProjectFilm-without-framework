package com.victorp.controller;

import com.victorp.service.GetFilmsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetFilmByIdController implements Controller {
    private GetFilmsService getFilmsService;

    public GetFilmByIdController(GetFilmsService getFilmsService) {
        this.getFilmsService = getFilmsService;
    }

    @Override
    public void controller(HttpServletRequest request, HttpServletResponse response) {
       Long id = Long.parseLong(request.getParameter("f_id"));
        request.setAttribute("filmById", getFilmsService.getFilmById(id));
        try {
            request.getRequestDispatcher("/WEB-INF/view/description.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
