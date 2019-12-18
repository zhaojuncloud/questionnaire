package com.rst.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rst.dao.OptionsMapper;
import com.rst.dao.QuestionMapper;
import com.rst.dao.QuestionnaireMapper;
import com.rst.dao.QuestionnaireQuestionsMapper;
import com.rst.dao.ResultMapper;
import com.rst.dao.UserQuestionnaireMapper;
import com.rst.pojo.Option;
import com.rst.pojo.Question;
import com.rst.pojo.Questionnaire;
import com.rst.pojo.ResultPo;
import com.rst.pojo.User;
import com.rst.service.QuestionService;
import com.rst.service.QuestionnaireService;
import com.rst.utils.IdUtil;
import com.rst.utils.ThreadLocalUtil;
import com.rst.vo.QuestionAndOptions;
import com.rst.vo.QuestionnaireTest;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
	/*
	 * 自动注入问卷的映射器
	 */
	@Autowired
	private QuestionnaireMapper questionnaireMapper;

	/*
	 * 注入问卷内容表的映射器
	 */
	@Autowired
	private QuestionnaireQuestionsMapper qQMapper;

	@Autowired
	private OptionsMapper optionsMapper;
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private UserQuestionnaireMapper uQMapper;

	@Autowired
	private QuestionService questionService;
	/*
	 * 将问卷数据（包括问卷中的内容）插入到数据库中，
	 */
	@Autowired
	private ResultMapper resultMapper;

	@Override
	public void addQuestionnaireService(Questionnaire questionnaire) {
		questionnaire.setCreateTime(new Date());
		questionnaireMapper.addQuestionnaire(questionnaire);
		List<Integer> questionsId = questionnaire.getQuestionsId();
		Integer quenairId = questionnaire.getId();
		for (Integer questionId : questionsId) {
			qQMapper.addQuestionById(quenairId, questionId);
		}

	}

	@Override
	public QuestionnaireTest getQuestionAndOptions(Integer questionnaireId) {
		List<QuestionAndOptions> qaoList = new ArrayList<QuestionAndOptions>();
		/*
		 * 
		 * 通过问卷id获取问题数据id 根据问题id获取选项id 将问卷进行封装，返回给前端
		 */
		Questionnaire questionnaire = questionnaireMapper.getQuestionnaireById(questionnaireId);
		List<Integer> questionsId = qQMapper.getQuestionsIdById(questionnaireId);
		for (Integer id : questionsId) {
			QuestionAndOptions questionAndOptions = questionService.getQuestionAndOptions(id);
			qaoList.add(questionAndOptions);
		}
		QuestionnaireTest qt = new QuestionnaireTest();
		qt.setQaos(qaoList);
		qt.setQuestionnaire(questionnaire);

		return qt;
	}

	/*
	 * 获取当前用户的所有试卷id
	 * 
	 */
	@Override
	public Questionnaire getQuestionnaireMessage() {
		User user = ThreadLocalUtil.getUser();
		List<Integer> QuestionnaireIdList = uQMapper.getQuestionnaireIdById(user.getId());
		return null;
	}

	/*
	 * 解析结果数据
	 */
	@Override
	public void disResult(QuestionnaireTest qt,Integer userId) {
		Questionnaire questionnaire = qt.getQuestionnaire();
		Integer questionnaireId = questionnaire.getId();
		List<QuestionAndOptions> qaos = qt.getQaos();
		for (QuestionAndOptions qao : qaos) {
			resultToDatabase(questionnaireId, qao,userId);
		}
	}

	private void resultToDatabase(Integer questionnaireId, QuestionAndOptions qao,Integer userId) {

		Question question = qao.getQuestion();
		Integer questionId = question.getId();
		List<Option> options = qao.getOptions();
		for (Option option : options) {
			Integer optionId = option.getId();
			ResultPo result = new ResultPo();
			result.setUserId(userId);
			result.setOptionsId(optionId);
			result.setQuestionnaireId(questionnaireId);
			result.setQuestionId(questionId);
			result.setScore(getOptionScore(optionId));
			result.setCreateTime(new Date());
			resultMapper.insertResult(result);
		}
	}

	/*
	 * 获取选项信息
	 */
	private Integer getOptionScore(Integer optionId) {
		if (optionId == null)
			return 0;
		Option option = optionsMapper.getOptionById(optionId);
		if (option == null)
			return 0;
		return option.getScore();
	}

	@Override
	public boolean verResult(Integer questionnaireId, Integer userId) {
		List<ResultPo> verResult = resultMapper.verResult(questionnaireId, userId);
		if (verResult.size() == 0)
			return false;
		return true;// 表示不存在
	}

	@Override
	public Integer getSum(Integer questionnaireId, Integer userId) {
		Integer doSum = resultMapper.doSum(questionnaireId, userId);
		return doSum;
	}

	@Override
	public List<QuestionAndOptions> getAllOptionsById(Integer questionnaireId, Integer userId) {
		// 获取当前用户所做指定试卷的结果集
		List<ResultPo> results = resultMapper.verResult(questionnaireId, userId);
		List<QuestionAndOptions> qaoList = new ArrayList<QuestionAndOptions>();
		// 遍历结果集，获取问题id
		for (ResultPo result : results) {
			Integer questionId = result.getQuestionId();
			/*
			 * 通过用户id和试卷id及问题id,获取选项id结果为集合
			 */
			QuestionAndOptions questionAndOptions = getResultByQuestAndUser(userId, questionnaireId, questionId);
			qaoList.add(questionAndOptions);
		}
		return qaoList;
	}

	private QuestionAndOptions getResultByQuestAndUser(Integer userId, Integer questionnaireId, Integer questionId) {
		QuestionAndOptions qao = new QuestionAndOptions();
		List<Option> options = new ArrayList<Option>();
		// 获得问题
		Question question = questionMapper.getQuestionById(questionId);

		// 获取选项集合

		List<Integer> optionsId = resultMapper.getOptionsId(questionnaireId, userId, questionId);
		for (Integer optionId : optionsId) {
			if (optionId == null) {
				Option option = new Option();
				option.setOptCon("否");
				options.add(option);
			} else {
				Option option = optionsMapper.getOptionById(optionId);
				options.add(option);
			}

		}
		qao.setQuestion(question);
		qao.setOptions(options);
		return qao;
	}

}
