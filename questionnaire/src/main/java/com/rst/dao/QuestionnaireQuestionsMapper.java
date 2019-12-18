package com.rst.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface QuestionnaireQuestionsMapper {
	
	void addQuestionById(@Param("questionnaire_id")Integer questionnaireId,
			@Param("question_id")Integer questionId);
	List<Integer> getQuestionsIdById(Integer id);
}
