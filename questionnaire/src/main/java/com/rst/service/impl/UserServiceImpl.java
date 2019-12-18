package com.rst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rst.dao.QuestionnaireMapper;
import com.rst.dao.UserMapper;
import com.rst.dao.UserQuestionnaireMapper;
import com.rst.pojo.Questionnaire;
import com.rst.pojo.User;
import com.rst.service.UserService;
import com.rst.utils.ThreadLocalUtil;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserQuestionnaireMapper uQmapper;
	@Autowired
	private QuestionnaireMapper questionnaireMApper;
	@Override
	public User doLogin(User user) {
		String userName = user.getUserName();
		User realUser = userMapper.getUserByUserName(userName);
		if (realUser == null)
			return null ;
		if (!user.getPwd().equals(realUser.getPwd()))
			return null;
		realUser.setPwd(null);
		user=realUser;
		return user;
	}

	@Override
	public List<Questionnaire> findQuestionaire(Integer userId) {
		List<Integer> questionnaireId = uQmapper.getQuestionnaireIdById(userId);
		List<Questionnaire> questionnaires = questionnaireMApper.getQuestionnaires(questionnaireId);
		return questionnaires;
	}

}
