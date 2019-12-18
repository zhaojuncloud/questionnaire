package com.rst.utils;

import com.rst.pojo.User;

public class ThreadLocalUtil {
	private static ThreadLocal<User> thread = new ThreadLocal<>();

	public static void setUser(User user) {
		thread.set(user);
	}

	public static User getUser() {
		return thread.get();
	}

	public static void removeUser() {
		thread.remove();
	}
}