package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserServise;

@Controller
public class AddUserController {

    private final UserServise userServise;

    public AddUserController(UserServise userServise) {
        this.userServise = userServise;
    }
    @GetMapping(value = "/users")
    public String printWelcome(ModelMap model) {


        model.addAttribute("people",userServise.getAllUsers());

        return "users";
    }

    @GetMapping("/reg")
    public String AddUsercontr (@RequestParam(name = "id",required = false) Long id,Model model){
        if(id==null) {
            model.addAttribute("user", new User());
        }else {
            model.addAttribute("user",userServise.readUser(id));
        }

        return "reg";
    }
    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user) {

            userServise.createOrUpdate(user);

        return "redirect:/users";
    }

    @GetMapping("/deleteUser")
    public String deletaGetUser(@RequestParam(name = "id")Long id){

        userServise.deleteUser(id);
        return "redirect:/users";

    }


}
