package com.rst.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rst.pojo.Questionnaire;

public interface QuestionnaireMapper {
	
	void addQuestionnaire(Questionnaire questionnaire);
	Questionnaire getQuestionnaireById(Integer id);
	 List<Questionnaire> getQuestionnaires(@Param("questionnaireIds")List<Integer> questionnaireIds);
}
