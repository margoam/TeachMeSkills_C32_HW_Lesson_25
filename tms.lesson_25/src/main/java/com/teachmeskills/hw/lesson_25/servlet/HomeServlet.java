package com.teachmeskills.hw.lesson_25.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/homepage")
public class HomeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        String role = (String) req.getSession().getAttribute("role");

        if (username != null && role != null) {
            resp.getWriter().println("User: " + username + ", Role: " + role);
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied: You are not logged in.");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
