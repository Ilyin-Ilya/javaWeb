package ua.karazin.ilyin.javaweb.web.servlet;

import ua.karazin.ilyin.javaweb.dao.DBUtils;
import ua.karazin.ilyin.javaweb.entity.Answer;
import ua.karazin.ilyin.javaweb.entity.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/info")
public class QuestionInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/question.jsp");
        DBUtils utils = new DBUtils();
        try {
            Question question = utils.findQuestion(Integer.parseInt(req.getParameter("id")), utils.setConnection());
            ArrayList<Answer> answers = utils.getAllAnswers(question, utils.setConnection());
            req.setAttribute("question", question);
            req.setAttribute("answers", answers);
            requestDispatcher.forward(req, resp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
