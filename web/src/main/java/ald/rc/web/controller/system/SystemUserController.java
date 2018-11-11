package ald.rc.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ald.rc.dal.bo.SystemUser;

@Controller
public class SystemUserController {
	
	@RequestMapping(value="/system/user")
	public String index(SystemUser user) throws Exception{
		return "system/user :: userList";
	}
	

}
