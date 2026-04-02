package com.winter.app.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("value="/", method = RequestMethod.GET)
	public String home() {
		
		return "/WEB-INF/views/index.jsp";
	}
	
}
