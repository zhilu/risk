package ald.rc.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemRoleController {
	
	@RequestMapping("system/role")
	public String index() {
		return "system/role :: roleList";
		
	}

}
