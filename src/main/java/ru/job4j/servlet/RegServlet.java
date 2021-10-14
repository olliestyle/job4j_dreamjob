package ru.job4j.servlet;

import ru.job4j.model.User;
import ru.job4j.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        if (PsqlStore.instOf().findUserByEmail(email) != null) {
            req.setAttribute("message", "Пользователь с таким email уже зарегистрирован");
            req.getRequestDispatcher("reg.jsp").forward(req, resp);
        } else {
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            PsqlStore.instOf().saveUser(new User(0, name, email, password));
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
