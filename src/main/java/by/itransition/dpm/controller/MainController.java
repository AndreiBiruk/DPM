package by.itransition.dpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/home";
    }

    @RequestMapping("home")
    public String index() {
        return "home";
    }

    @RequestMapping("/registration")
    public String registration() {
        return "registration";
    }

}