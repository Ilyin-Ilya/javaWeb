package ua.karazin.ilyin.javaweb.web.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.karazin.ilyin.javaweb.dao.DBUtils;
import ua.karazin.ilyin.javaweb.entity.Role;
import ua.karazin.ilyin.javaweb.entity.User;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
@RequestMapping("/register")
public class RegistrationServlet {

    private DBUtils dbUtils;

    @Autowired
    public RegistrationServlet(DBUtils utils) {
        this.dbUtils = utils;
    }

    @GetMapping
    protected String doGet(ModelAndView view) throws ServletException, IOException {
        view.setViewName("registration");
        return "registration";
    }

    @PostMapping
    @ModelAttribute
    protected ModelAndView doPost(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  Model model,
                                  ModelAndView view) throws IOException {
        User user = obtainUser(username, password);
        boolean isUserAdd = addUser(user);
        if (isUserAdd) {
            ModelAndView a = new ModelAndView("redirect:/questions");
            a.addObject("user", user);
            return a;
        }
        return new ModelAndView("redirect:/questions");
    }

    private User obtainUser(String username, String password) {
        User user = new User();
        user.setLogin(username);
        user.setPassword(password);
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
