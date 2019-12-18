package com.rst.dao;


import com.rst.pojo.User;

public interface UserMapper {
	User getUserByUserName(String userName);
	
}
