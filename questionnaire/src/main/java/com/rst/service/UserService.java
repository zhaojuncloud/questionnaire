package com.rst.service;

import java.util.List;

import com.rst.pojo.Questionnaire;
import com.rst.pojo.User;

public interface UserService {

	User doLogin(User user);

	List<Questionnaire> findQuestionaire(Integer userId);

}
