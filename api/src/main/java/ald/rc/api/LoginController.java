package ald.rc.api;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ald.rc.api.bo.LoginModel;
import ald.rc.api.core.EventBaseController;
import ald.rc.api.core.EventContext;

@Controller
@Scope(value="prototype")
public class LoginController extends EventBaseController <LoginModel> {

	@Override
	protected EventContext getEventContext(LoginModel t) {
		return null;
	}
	
	@RequestMapping(value=ApiPath.LOGIN_ASY)
	public void loginAsy(LoginModel model){
		
	}
	
	@RequestMapping(value=ApiPath.LOGIN_SYN)
	public void loginSyn(LoginModel model){
		
	}

}
