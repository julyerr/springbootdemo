package com.julyerr.springboot.mvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/servlet")
public class ServletConfig extends HttpServlet {

    final static Logger logger = LoggerFactory.getLogger(ServletConfig.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("customer servlet get");
        super.doGet(req, resp);
    }
}
