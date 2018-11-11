package ald.rc.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemPrivilegeController {
	
	@RequestMapping("/system/privilege")
	public String index() {
		
		System.out.println("privilege");
		return "system/privilege :: privilege";
	}
}
