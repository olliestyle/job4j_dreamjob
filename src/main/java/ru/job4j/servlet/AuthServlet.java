package ru.job4j.servlet;

import org.mindrot.jbcrypt.BCrypt;
import ru.job4j.model.User;
import ru.job4j.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User toTest = PsqlStore.instOf().findUserByEmail(email);
        if (toTest != null && BCrypt.checkpw(password, toTest.getPassword())) {
            HttpSession sc = req.getSession();
            sc.setAttribute("user", toTest);
            resp.sendRedirect(req.getContextPath() + "/posts.do");
        } else {
            req.setAttribute("error", "Не верный email или пароль");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
