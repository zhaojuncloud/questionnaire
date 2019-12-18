package com.rst.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page/")
public class PageController {
	@RequestMapping("create_table")
	public String pageCreatequestionnaire() {
		return "create_questionnaire";
	}

	@RequestMapping("test")
	public String doTest(Integer id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("questionnaireId", id);
		return "questionnaire";
	}
	@RequestMapping("result")
	public String doResult() {
		return "result";
	}
}
