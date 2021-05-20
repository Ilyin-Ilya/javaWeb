package ua.karazin.ilyin.javaweb.web.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.karazin.ilyin.javaweb.dao.DBUtils;
import ua.karazin.ilyin.javaweb.dto.QuestionDisplay;
import ua.karazin.ilyin.javaweb.entity.Question;
import ua.karazin.ilyin.javaweb.entity.User;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionListServlet extends HttpServlet {

    private DBUtils dbUtils;

    @Autowired
    public QuestionListServlet(DBUtils utils) {
        this.dbUtils = utils;
    }

    @GetMapping
    @ModelAttribute
    protected ModelAndView doGet(Model model, @ModelAttribute("user") User user, ModelAndView view, RedirectAttributes attr) {
        try {

            List<Question> questions = dbUtils.getAllQuestions();
            ArrayList<QuestionDisplay> display = new ArrayList<>();

            for (Question item : questions) {
                display.add(new QuestionDisplay(item));
            }

            view.addObject("questions", display);
            view.addObject("user");
            view.setViewName("questions");
            return view;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

}
