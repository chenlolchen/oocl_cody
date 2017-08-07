package controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import pojo.User;

import java.util.Date;

/**
 * Created by CHENCO7 on 8/7/2017.
 */
@Controller
//@RequestMapping("/users")
public class TestController {
//    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        // call service
//        String uname = "chen";
//        ModelAndView mv = new ModelAndView("suc");
//        mv.addObject("uname", uname);
//        return mv;
//    }

    //    @RequestMapping(value = "/user/**/test1*?")
    @RequestMapping(value = {"/test1"})
//    @GetMapping
    public String test1(Model model) {
        model.addAttribute("uname", "chen");
        return "suc";
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
//    @PostMapping
    public String test2(Model model) {
        model.addAttribute("uname", "lol");
        return "suc";
    }

//    @RequestMapping(value = "/test1", headers = {"Content-Type=application/json"})
    @RequestMapping(value = "/test1", consumes = "application/json", produces = "application/json")
    public String test3(Model model){
        model.addAttribute("uname", "tom");
        return "suc";
    }

    @RequestMapping(value = "/test1", params = {"id=1"})
    public String test4(Model model){
        model.addAttribute("uname", "pppp");
        return "suc";
    }

    @RequestMapping(value = "/test2")
    public String test5(String uname, int age, @DateTimeFormat(pattern = "yyyy-MM-dd") Date birth, Model model){
        System.out.println(birth);
        model.addAttribute("uname", uname);
        model.addAttribute("age", age);
        return "suc";
    }

    @RequestMapping(value = "/test3")
    public String test5(User u, Model model){
        System.out.println(u.getName() + u.getAge() + u.getBirth());
        return "suc";
    }

    @RequestMapping(value = "/test4")
    public String test6(@CookieValue(value = "JSESSIONID") String key, Model model){
        System.out.println(key);
        return "suc";
    }

    @RequestMapping(value = "/users/{uid}/books/{bid}")
    public String test7(@PathVariable(value = "uid") String uid,@PathVariable int bid, Model model){
        System.out.println("uid = " + uid);
        System.out.println("bid = " + bid);
        return "suc";
    }

    @RequestMapping(value = "/test5", consumes = "application/json")
    @ResponseBody
    public User test8(@RequestBody User u, Model model){
        System.out.println(u.getName() + u.getAge() + u.getBirth());
        return u;
    }
}
