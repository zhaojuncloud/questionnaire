package com.rst.service;

import java.util.List;

import com.rst.pojo.Question;
import com.rst.vo.QuestionAndOptions;

public interface QuestionService {
	void addQuestion(Question question);
	//通过问题id获取完整的题
	QuestionAndOptions getQuestionAndOptions(Integer id);
	List<Question> getAllQuestion();
	void createQuestion(Question question);
}
