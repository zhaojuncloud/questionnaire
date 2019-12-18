package com.rst.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rst.pojo.User;
import com.rst.service.UserService;
import com.rst.utils.CookieUtil;
import com.rst.vo.Result;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("login")
	public String login() {
		return "login";
	}

	@RequestMapping("doLogin")
	public String doLogin(User user, HttpServletResponse response) {

		User realUser = userService.doLogin(user);
		Integer id = realUser.getId();
		CookieUtil.addCookie(response, "userId", id.toString(), 60000 * 30, null);
		if (realUser != null)
			return "index";
		return "login";
	}

}
