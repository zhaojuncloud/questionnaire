package com.rst.service;

import java.util.List;

import com.rst.pojo.Questionnaire;
import com.rst.pojo.ResultPo;
import com.rst.vo.QuestionAndOptions;
import com.rst.vo.QuestionnaireTest;

public interface QuestionnaireService {
	void addQuestionnaireService(Questionnaire questionnaire);
	QuestionnaireTest getQuestionAndOptions(Integer id);
	Questionnaire getQuestionnaireMessage();
	void disResult(QuestionnaireTest qt,Integer userId);
	boolean verResult(Integer questionnaireId, Integer userId);
	Integer getSum(Integer questionnaireId, Integer userId);
	List<QuestionAndOptions> getAllOptionsById(Integer questionnaireId, Integer userId);
}
