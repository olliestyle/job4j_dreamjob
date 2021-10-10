package ru.job4j.servlet;

import ru.job4j.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DeleteCandidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteCandidate = req.getParameter("id");
        Store.instOf().deleteCandidate(Integer.parseInt(deleteCandidate));
        InputStream in = PhotoUploadServlet.class.getClassLoader().getResourceAsStream("app.properties");
        Properties config = new Properties();
        config.load(in);
        File deleteFile = new File(config.getProperty("uploadPath") + deleteCandidate);
        if (deleteFile.exists()) {
            deleteFile.delete();
        }

        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
