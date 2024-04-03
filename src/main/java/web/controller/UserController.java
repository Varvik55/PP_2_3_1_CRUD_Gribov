package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserServise;

import javax.validation.Valid;

@Controller
@Validated
public class UserController {

    private final UserServise userServise;

    public UserController(UserServise userServise) {
        this.userServise = userServise;
    }


    @GetMapping(value = "/users")
    public String printWelcome(ModelMap model) {


        model.addAttribute("people",userServise.getAllUsers());

        return "users";
    }

    @GetMapping("/reg")
    public String addUser (@RequestParam(name = "id",required = false) Long id,Model model){
        if(id==null) {
            model.addAttribute("user", new User());
        }else {
            model.addAttribute("user",userServise.readUser(id));
        }

        return "reg";
    }
    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "reg";
        }
            userServise.createOrUpdate(user);

        return "redirect:/users";
    }

    @GetMapping("/deleteUser")
    public String daleteUser(@RequestParam(name = "id")Long id){

        userServise.deleteUser(id);
        return "redirect:/users";

    }


}
