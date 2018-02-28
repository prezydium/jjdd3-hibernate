package com.infoshareacademy.web;

import com.infoshareacademy.dao.ComputerDao;
import com.infoshareacademy.dao.ComputerDao;
import com.infoshareacademy.model.Computer;
import com.infoshareacademy.model.Computer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@WebServlet(urlPatterns = "/computer")
public class ComputerServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(ComputerServlet.class);

    @Inject
    private ComputerDao computerDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        computerDao.save(new Computer("ROG ASUS", "Windows"));
        computerDao.save(new Computer("KompWyniesionyZUrzedu", "DOS"));

        LOG.info("System time zone is: {}", ZoneId.systemDefault());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {

        final String action = req.getParameter("action");
        LOG.info("Requested action: {}", action);
        if (action == null || action.isEmpty()) {
            resp.getWriter().write("Empty action parameter.");
            return;
        }

        if (action.equals("findAll")) {
            findAll(req, resp);
        } else if (action.equals("add")) {
            addComputer(req, resp);
        } else if (action.equals("delete")) {
            deleteComputer(req, resp);
        } else if (action.equals("update")) {
            updateComputer(req, resp);
        } else {
            resp.getWriter().write("Unknown action.");
        }
    }

    private void updateComputer(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
        final Long id = Long.parseLong(req.getParameter("id"));
        LOG.info("Updating Computer with id = {}", id);

        final Computer existingComputer = computerDao.findById(id);
        if (existingComputer == null) {
            LOG.info("No Computer found for id = {}, nothing to be updated", id);
        } else {
            existingComputer.setName(req.getParameter("name"));

            computerDao.update(existingComputer);
            LOG.info("Computer object updated: {}", existingComputer);
        }

        // Return all persisted objects
        findAll(req, resp);
    }

    private void addComputer(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {

        final Computer p = new Computer();
        p.setName(req.getParameter("name"));
        p.setOperatingSystem(req.getParameter("operatingsystem"));

        computerDao.save(p);
        LOG.info("Saved a new Computer object: {}", p);

        // Return all persisted objects
        findAll(req, resp);
    }

    private void deleteComputer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final Long id = Long.parseLong(req.getParameter("id"));
        LOG.info("Removing Computer with id = {}", id);

        computerDao.delete(id);

        // Return all persisted objects
        findAll(req, resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final List<Computer> result = computerDao.findAll();
        LOG.info("Found {} objects", result.size());
        for (Computer p : result) {
            resp.getWriter().write(p.toString() + "\n");
        }
    }
}

