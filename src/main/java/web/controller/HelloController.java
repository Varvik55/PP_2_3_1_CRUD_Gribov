package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserServise;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
	private final UserServise userServise;

	public HelloController(UserServise userServise) {
		this.userServise = userServise;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {


		return "index";
	}

	
}