package ua.karazin.ilyin.javaweb.web.listener;

import ua.karazin.ilyin.javaweb.dao.DBUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("db_utils", new DBUtils());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
