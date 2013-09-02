package by.itransition.dpm.controller;

import by.itransition.dpm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    BookService bookService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/home";
    }

    @RequestMapping("home")
    public String index(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "home";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("registration")
    public String registration() {
        return "registration";
    }

}