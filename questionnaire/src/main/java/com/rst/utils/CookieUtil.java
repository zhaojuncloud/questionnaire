package com.rst.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	/*
	 * 编辑工具api方法,通过cookie的名称,获取cookie的值
	 */
	public static String getCookieValue(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length == 0)
			return null;
		String value = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cookieName)) {
				value = cookie.getValue();
				break;
			}
		}
		return value;

	}
	public static void addCookie(
			HttpServletResponse response,
			String cookieName,
			String cookieValue,
			int seconds,
			String domain) {
		Cookie ticketCookie = new Cookie(cookieName, cookieValue);
		ticketCookie.setMaxAge(seconds);// 七天有效
		ticketCookie.setPath("/");// 权限设定
		ticketCookie.setDomain("localhost");
		response.addCookie(ticketCookie);
	}
}
