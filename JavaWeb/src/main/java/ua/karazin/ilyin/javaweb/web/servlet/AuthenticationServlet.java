package ua.karazin.ilyin.javaweb.web.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.karazin.ilyin.javaweb.dao.DBUtils;
import ua.karazin.ilyin.javaweb.entity.User;

import java.util.Objects;

@Controller
@RestController("/login")
public class AuthenticationServlet {

    private DBUtils dbUtils;

    @Autowired
    public AuthenticationServlet(DBUtils utils) {
        this.dbUtils = utils;
    }


    @GetMapping
    protected String doGet(ModelAndView view) {
        return "index";
    }

    @PostMapping
    protected ModelAndView doPost(@RequestParam("username") String name, @RequestParam("password") String password, ModelAndView modelAndView) {
        try {
            User user = dbUtils.findUserLogin(name);

            if (Objects.equals(user.getPassword(), password)) {
                ModelAndView a = new ModelAndView("redirect:/questions");
                a.addObject("user", new User(user));
                return a;
                // req.getSession().setAttribute("user", user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/questions");
    }

}
