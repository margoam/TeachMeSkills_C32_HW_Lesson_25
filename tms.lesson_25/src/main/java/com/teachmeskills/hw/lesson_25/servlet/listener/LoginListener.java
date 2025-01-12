package com.teachmeskills.hw.lesson_25.servlet.listener;

import com.teachmeskills.hw.lesson_25.logging.Logger;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener("/login")
public class LoginListener implements HttpSessionListener, ServletContextListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        String sessionId = se.getSession().getId();
        Logger.log("Session is created. SessionId: " + sessionId);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String username = (String) se.getSession().getAttribute("username");
        if (username != null) {
            Logger.log("User logged out: " + username);
        }
    }
}
