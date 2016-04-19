package com.aqiang.test.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageHandler {

	@RequestMapping("otherPage")
	public String otherPage() {
		return "otherPage";
	}

}
