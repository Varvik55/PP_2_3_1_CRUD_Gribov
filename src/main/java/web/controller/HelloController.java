package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserServise;


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