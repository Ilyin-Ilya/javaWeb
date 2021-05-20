package ua.karazin.ilyin.javaweb.web.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.karazin.ilyin.javaweb.dao.DBUtils;
import ua.karazin.ilyin.javaweb.entity.Answer;
import ua.karazin.ilyin.javaweb.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/info")
public class QuestionInfoServlet extends HttpServlet {
    private DBUtils dbUtils;

    @Autowired
    public QuestionInfoServlet(DBUtils utils) {
        this.dbUtils = utils;
    }

    @GetMapping
    protected ModelAndView doGet(@RequestParam("id") String id, ModelAndView view) throws ServletException, IOException {
        Question question = dbUtils.findQuestion(Integer.parseInt(id));
        List<Answer> answers = dbUtils.getAllAnswers(question);
        view.addObject("question", question);
        view.addObject("answers", answers);
        view.setViewName("question");
        return view;
    }

}
