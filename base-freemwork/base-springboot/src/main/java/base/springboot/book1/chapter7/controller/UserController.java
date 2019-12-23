package base.springboot.book1.chapter7.controller;

import base.springboot.book1.chapter7.domain.User;
import base.springboot.book1.chapter7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tangwei
 * @date 2019/12/23 10:29
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService = null;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public User insertUser() {
        User user = new User();
        String userName = "Clay";
        String note = "hh";
        user.setUserName(userName);
        user.setNote(note);
        userService.insertUser(user);
        return user;
    }

}
