package com.rst.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rst.dao.OptionsMapper;
import com.rst.dao.QuestionMapper;
import com.rst.pojo.Option;
import com.rst.pojo.Question;
import com.rst.service.QuestionService;
import com.rst.vo.QuestionAndOptions;

@Service
public class QuerstionServiceImpl implements QuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private OptionsMapper optionMapper;

	@Override
	public void addQuestion(Question question) {

	}

	/**
	 * 获取所有问题参数
	 */
	@Override
	public List<Question> getAllQuestion() {
		List<Question> allQuestions = questionMapper.getAllQuestions();
		return allQuestions;
	}

	@Override
	public QuestionAndOptions getQuestionAndOptions(Integer id) {
		Question question = questionMapper.getQuestionById(id);
		List<Option> options = optionMapper.getOptionByQuestionId(id);
		options = setQuestion(question, options);
		QuestionAndOptions qao = new QuestionAndOptions();
		qao.setQuestion(question);
		qao.setOptions(options);

		return qao;
	}

	// 判定选项为"是"和"否"的题
	private List<Option> setQuestion(Question question, List<Option> options) {
		Option option = new Option();
		option.setOptCon("否");
		if (question.getType() == 1 && options.size() == 1)
			options.add(option);
		return options;

	}

	@Override
	public void createQuestion(Question question) {
		Date date=new Date();
		question.setCreateUser("admin");
		question.setCreateTime(date);
		question.setEvalDeptId(111);
		question.setUpdateTime(date);
		questionMapper.createQuestion(question);
		List<Option> options = question.getOptions();
		for(Option option:options)
		{
			option.setCreateTime(date);
			option.setUpdateTime(date);
			option.setCreateUser("admin");
			option.setQuestionId(question.getId());
			optionMapper.createOption(option);
		}
		
	}
	

}
