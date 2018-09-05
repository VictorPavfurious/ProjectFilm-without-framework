package com.victorp;

import com.victorp.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ProcessServlet extends HttpServlet {

   private Map<Request, Controller> controllerHashMap = new HashMap<>();

    @Override
    public void init() {
        controllerHashMap.put(new Request("/servlet/getAllFilms", "GET"), Factory.getAllFilmsController());
        controllerHashMap.put(new Request("/servlet/description", "GET"), Factory.getFilmByIdController());
        controllerHashMap.put(new Request("/servlet/insertFilm", "POST"), Factory.insertFilmIntoDbController());
        controllerHashMap.put(new Request("/servlet/insertFilm", "GET"), processView().apply("insertFilm"));
        controllerHashMap.put(new Request("/servlet/deleteFilm", "POST"), Factory.deleteFilmController());
        controllerHashMap.put(new Request("/servlet/deleteFilm", "GET"), processView().apply("deleteFilm"));
        controllerHashMap.put(new Request("/servlet/signup", "POST"), Factory.createUserController());
        controllerHashMap.put(new Request("/servlet/signup", "GET"), processView().apply("signup"));
        controllerHashMap.put(new Request("/servlet/success", "GET"), processView().apply("success"));
        controllerHashMap.put(new Request("/servlet/login", "POST"), Factory.loginUserController());
        controllerHashMap.put(new Request("/servlet/login", "GET"), processView().apply("login"));
        controllerHashMap.put(new Request("/servlet/home", "GET"), processView().apply("home"));
        controllerHashMap.put(new Request("/servlet/logout", "POST"), Factory.logOutController());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }
    private Function<String, Controller> processView() {

        return x -> (req, resp) -> {
            try {
                req.getRequestDispatcher(String.format("/WEB-INF/view/%s.jsp", x)).forward(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        };
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        Request reqClass = new Request(request.getRequestURI(), request.getMethod());

        controllerHashMap.getOrDefault(reqClass, processView().apply("error")).controller(request, response);
    }

}
