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

    Map<Request, Controller> controllerHashMap = new HashMap<>();

    @Override
    public void init() {
        controllerHashMap.put(new Request("/servlet/getUsers", "GET"), Factory.getAllUsersController());
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
