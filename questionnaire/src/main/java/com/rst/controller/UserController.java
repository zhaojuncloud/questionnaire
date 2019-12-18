package com.rst.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rst.pojo.Questionnaire;
import com.rst.service.UserService;
import com.rst.utils.CookieUtil;
import com.rst.utils.IdUtil;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService userService;
	@ResponseBody
	@RequestMapping("findQuestionnaire")
	public List<Questionnaire> findQuestionnaire(HttpServletRequest request) {
		Integer userId = IdUtil.getUserId(request);
		List<Questionnaire> list=userService.findQuestionaire(userId);
		return list;
	}
}
