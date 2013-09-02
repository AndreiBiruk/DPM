package by.itransition.dpm.controller;

import by.itransition.dpm.entity.Book;
import by.itransition.dpm.entity.User;
import by.itransition.dpm.service.BookService;
import by.itransition.dpm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @RequestMapping("/user")
    public String currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "redirect:/user/" + authentication.getName();
    }

    @RequestMapping("/user/{username}")
    public String user(Model model, @PathVariable String username) {
        User user = userService.getUserByLogin(username);

        model.addAttribute("name", user.getUsername());
        model.addAttribute("books", bookService.getUserBooks(user));
        return "user";
    }
}