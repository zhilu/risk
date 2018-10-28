package ald.rc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/index")
	public String login() {
		System.out.println("hehehe");
		return "login";
	}

}
