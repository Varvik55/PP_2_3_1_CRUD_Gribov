package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserServise;

@Controller
public class AddUserController {

    private final UserServise userServise;

    public AddUserController(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping("/reg")
    public String AddUsercontr ( Model model){
        model.addAttribute("user",new User());
        return "reg";
    }
    @PostMapping()
    public String createUser (@ModelAttribute("user") User user){
    userServise.createUser(user);
        return "redirect:/";
    }
}
