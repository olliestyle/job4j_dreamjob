package ru.job4j.servlet;

import ru.job4j.model.Post;
import ru.job4j.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PsqlStore psqlStore = PsqlStore.instOf();
        req.setAttribute("posts", psqlStore.findAllPosts());
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.getRequestDispatcher("post/posts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PsqlStore psqlStore = PsqlStore.instOf();
        req.setCharacterEncoding("UTF-8");
        psqlStore.savePost(new Post(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), req.getParameter("description")));
        resp.sendRedirect(req.getContextPath() + "/posts.do");
    }
}