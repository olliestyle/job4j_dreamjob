package ru.job4j.servlet;

import ru.job4j.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class DeleteCandidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteCandidate = req.getParameter("id");
        Store.instOf().deleteCandidate(Integer.parseInt(deleteCandidate));

        File deleteFile = new File("/home/murat/images/" + deleteCandidate);
        if (deleteFile.exists()) {
            deleteFile.delete();
        }

        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
