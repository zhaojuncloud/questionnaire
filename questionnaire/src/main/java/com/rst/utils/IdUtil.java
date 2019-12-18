package com.rst.utils;

import javax.servlet.http.HttpServletRequest;

public class IdUtil {
	public static Integer getUserId(HttpServletRequest request) {
		String cookieValue = CookieUtil.getCookieValue(request, "userId");
		Integer userId = Integer.parseInt(cookieValue);
		return userId;
	}
	public static Integer getQuestionnaireId(HttpServletRequest request)
	{
		Object questionnaireId = request.getSession().getAttribute("questionnaireId");
		Integer id=(Integer)questionnaireId;
		return id;
	}
}
