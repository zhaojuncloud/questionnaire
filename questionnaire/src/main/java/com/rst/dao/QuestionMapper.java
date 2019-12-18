package com.rst.dao;

import java.util.List;

import com.rst.pojo.Question;

public interface QuestionMapper {

	List<Question> getAllQuestions();
	Question	getQuestionById(Integer id);
	void createQuestion(Question question);
}
