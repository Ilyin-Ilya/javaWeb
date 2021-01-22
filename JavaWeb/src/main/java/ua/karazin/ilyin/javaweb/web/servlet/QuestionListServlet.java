package ua.karazin.ilyin.javaweb.web.servlet;

import ua.karazin.ilyin.javaweb.dao.DBUtils;
import ua.karazin.ilyin.javaweb.dto.QuestionDisplay;
import ua.karazin.ilyin.javaweb.entity.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/questions")
public class QuestionListServlet extends HttpServlet {

    private DBUtils dbUtils;

    @Override
    public void init() {
        ServletContext servletContext = getServletContext();
        dbUtils = (DBUtils) servletContext.getAttribute("db_utils");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // dbUtils.getAllQuestions() --> list --> list<questionDisplays> --> questionList
        DBUtils utils = new DBUtils();
        try {

            ArrayList<Question> questions = dbUtils.getAllQuestions(dbUtils.setConnection());
            ArrayList<QuestionDisplay> display = new ArrayList<>();

            for (Question item : questions) {
                display.add(new QuestionDisplay(item));
            }


            req.setAttribute("questions", display);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/questions.jsp");
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
