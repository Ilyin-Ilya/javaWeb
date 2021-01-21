package ua.karazin.ilyin.javaweb.web.servlet;

import ua.karazin.ilyin.javaweb.dao.DBUtils;
import ua.karazin.ilyin.javaweb.entity.Role;
import ua.karazin.ilyin.javaweb.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@WebListener("/register")
public class RegistrationServlet extends HttpServlet {

    private DBUtils dbUtils;

    @Override
    public void init() throws ServletException {
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
            resp.sendRedirect("/login");
        }
    }

    private User obtainUser(HttpServletRequest req) {
        User user = new User();
        user.setLogin(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setRole(new Role(2, "user"));
        return user;
    }

    private boolean addUser(User user) {
        try {
            return dbUtils.addUser(user, dbUtils.setConnection());
        } catch (IOException | InstantiationException |
                InvocationTargetException | IllegalAccessException |
                NoSuchMethodException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
