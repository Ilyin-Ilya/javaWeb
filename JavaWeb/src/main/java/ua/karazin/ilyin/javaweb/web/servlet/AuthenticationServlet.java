package ua.karazin.ilyin.javaweb.web.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.karazin.ilyin.javaweb.dao.DBUtils;
import ua.karazin.ilyin.javaweb.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Controller
public class AuthenticationServlet {

    private DBUtils dbUtils;

    @Autowired
    public AuthenticationServlet(DBUtils utils) {
        this.dbUtils = utils;
    }

    ;

    @GetMapping("/login")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @PostMapping("/login")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            User user = dbUtils.findUserLogin(req.getParameter("username"));

            if (Objects.equals(user.getPassword(), req.getParameter("password"))) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/questions");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
