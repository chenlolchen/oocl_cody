package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.User;
import service.UserService;

import javax.annotation.Resource;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
@Controller
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String name, String password, Model model){
        if(userService.login(name, password) != null){
            return "success";
        }else {
            model.addAttribute("error", "用户名密码错误");
            return "login";
        }
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user){
        if(userService.register(user) != null){
            return "redirect:login.jsp";
        }else {
            return "register";
        }
    }
}
