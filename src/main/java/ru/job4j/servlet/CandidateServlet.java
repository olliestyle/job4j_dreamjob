package ru.job4j.servlet;

import ru.job4j.model.Candidate;
import ru.job4j.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CandidateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("candidates", PsqlStore.instOf().findAllCandidates());
        req.setAttribute("cities", PsqlStore.instOf().findAllCities());
        req.getRequestDispatcher("candidate/candidates.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String cityid = req.getParameter("cityId");
        PsqlStore.instOf()
                .saveCandidate(
                        new Candidate(Integer.parseInt(req.getParameter("id")),
                                      req.getParameter("name"),
                                      Integer.parseInt(req.getParameter("cityId"))));
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
