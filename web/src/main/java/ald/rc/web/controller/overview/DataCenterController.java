package ald.rc.web.controller.overview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataCenterController {
	
	@RequestMapping("overview/center")
	public String index() {
		return "overview/center :: center";
	}

}
