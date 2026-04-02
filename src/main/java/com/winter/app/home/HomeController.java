package com.winter.app.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("value="/", method = RequestMethod.GET)
	public String home() {
		
		int a=0;
		if(a%2==0) {
			throw new Excepetion();
		}
		return "/WEB-INF/views/index.jsp";
	}
	
}
