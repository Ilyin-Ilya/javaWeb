package ua.karazin.ilyin.javaweb.web.servlet;

import ua.karazin.ilyin.javaweb.dao.DBUtils;
import ua.karazin.ilyin.javaweb.entity.Role;
import ua.karazin.ilyin.javaweb.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private DBUtils dbUtils;

    @Override
    public void init() {
        ServletContext servletContext = getServletContext();
        dbUtils = (DBUtils) servletContext.getAttribute("db_utils");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = obtainUser(req);
        boolean isUserAdd = addUser(user);
        if (isUserAdd) {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    private User obtainUser(HttpServletRequest req) {
        User user = new User();
        user.setLogin(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        Role role = new Role();
        role.setId(2);
        role.setTitle("user");
        user.setRole(role);
        return user;
    }

    private boolean addUser(User user) {
        return dbUtils.addUser(user);
    }
}
