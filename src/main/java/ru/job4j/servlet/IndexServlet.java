package ru.job4j.servlet;

import ru.job4j.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("candidates", PsqlStore.instOf().findLastDayCandidates());
        req.setAttribute("posts", PsqlStore.instOf().findLastDayPosts());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
