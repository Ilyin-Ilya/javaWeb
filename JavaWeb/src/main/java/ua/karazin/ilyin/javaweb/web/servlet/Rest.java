package ua.karazin.ilyin.javaweb.web.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.karazin.ilyin.javaweb.dao.DBUtils;
import ua.karazin.ilyin.javaweb.entity.Role;
import ua.karazin.ilyin.javaweb.entity.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class Rest {

    private DBUtils dbUtils;

    @Autowired
    public Rest(DBUtils utils) {
        this.dbUtils = utils;
    }

    @GetMapping
    protected Map<Integer, String> doGet() {
        ArrayList<User> res = dbUtils.getAllUsers();
        HashMap<Integer, String> map = new HashMap<>();
        for (User i : res)
            map.put(i.getId(), i.getLogin());
        return map;
    }

    @PostMapping
    protected Map<Integer, String> doPost(@RequestParam("username") String username,
                                          @RequestParam("password") String password)
            throws IOException {
        User user = obtainUser(username, password);
        boolean isUserAdd = addUser(user);
        return this.doGet();
    }

    @PutMapping
    protected Map<Integer, String> doPut(@RequestParam("id") Integer user_id,
                                         @RequestParam("username") String username)
            throws IOException {
        ArrayList<User> res = dbUtils.getAllUsers();
        HashMap<Integer, String> map = new HashMap<>();
        for (User i : res) {
            if (i.getId() == user_id) {
                i.setLogin(username);
            }
        }
        for (User i : res)
            map.put(i.getId(), i.getLogin());

        return map;
    }

    @DeleteMapping
    protected Map<Integer, String> doDelete(@RequestParam("id") Integer user_id)
            throws IOException {
        ArrayList<User> res = dbUtils.getAllUsers();
        HashMap<Integer, String> map = new HashMap<>();
        res.removeIf(i -> i.getId() == user_id);
        for (User i : res)
            map.put(i.getId(), i.getLogin());

        return map;
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
