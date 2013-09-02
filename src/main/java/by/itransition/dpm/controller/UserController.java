package by.itransition.dpm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/user")
    public String currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "redirect:/user/" + authentication.getName();
    }

    @RequestMapping("/user/{username}")
    public String user(Model model, @PathVariable String username) {
        model.addAttribute("name", username);
        return "user";
    }
}