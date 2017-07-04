package com.aqiang.test.springmvc.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aqiang.test.entities.User;

@Controller
public class HomePageHandler {

	@RequestMapping("otherPage")
	public String otherPage(Map<String, Object> map) {
		map.put("test", "Hello.123");
		return "otherPage";
	}
	
	@RequestMapping("testJson")
	@ResponseBody
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User());
		return users;
	}

	@RequestMapping("testReq")
	public String testRequest(HttpServletRequest req, HttpServletResponse res) {
		System.out.println(req);
		System.out.println(res);
		req.setAttribute("Hello", "123");
		return "tesreq";
	}
}
