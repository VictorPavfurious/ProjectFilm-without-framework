package com.victorp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
    void controller (HttpServletRequest request, HttpServletResponse response);
}
