package ald.rc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ald.rc.api.bo.LoanModel;
import ald.rc.api.core.EventBaseController;
import ald.rc.api.core.EventContext;

@Controller
@Scope(value = "prototype")
public class LoanController extends EventBaseController<LoanModel> {

	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
	@Override
	protected EventContext getEventContext(LoanModel t) { 
		return null;
	}

	@RequestMapping(value = ApiPath.LOAN_ASY)
	public void loanAsy(LoanModel model) {
		logger.info("{}",model);
	}

	@RequestMapping(value = ApiPath.LOAN_SYN)
	public void loanSyn(LoanModel model) {

	}

}
