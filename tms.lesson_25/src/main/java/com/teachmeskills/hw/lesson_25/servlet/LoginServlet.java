package com.teachmeskills.hw.lesson_25.servlet;

import com.teachmeskills.hw.lesson_25.logging.Logger;
import com.teachmeskills.hw.lesson_25.model.User;
import com.teachmeskills.hw.lesson_25.storage.UserStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || password == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Username and password are required.");
            return;
        }

        User user = UserStorage.userDatabase.get(username);

        if (user != null && user.getPassword().equals(password)) {
            req.getSession().setAttribute("username", user.getLogin());
            req.getSession().setAttribute("role", user.getRole());

            Logger.log("User logged in: " + user.getLogin() + " (Role: " + user.getRole() + ")");
            resp.getWriter().println("Hi, " + user.getLogin() + "! Your role is " + user.getRole());
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid username or password.");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
