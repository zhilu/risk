package ald.rc.web.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ald.rc.dal.bo.SystemUser;
import ald.rc.web.core.BaseController;

@Controller
public class UserController extends BaseController {

	private static final Logger logger =LogManager.getLogger(UserController.class);
	
	
	@RequestMapping(value="/login")
	public String login(SystemUser user) throws Exception{
		
		logger.info("login");
		return "home";
	}
	
	@RequestMapping(value="/user/user")
	public String user() throws Exception{
		
		logger.info("login");
		return "user/user";
	}

	
	@RequestMapping(value="/user/setting")
	public String setting(SystemUser user) throws Exception{
		
		logger.info("login");
		return "user/setting :: setting";
	}


}
