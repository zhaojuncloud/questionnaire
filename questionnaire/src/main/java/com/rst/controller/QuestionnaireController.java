package com.rst.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rst.pojo.Questionnaire;
import com.rst.pojo.ResultPo;
import com.rst.service.QuestionnaireService;
import com.rst.utils.IdUtil;
import com.rst.vo.QuestionAndOptions;
import com.rst.vo.QuestionnaireTest;
import com.rst.vo.Result;

/**
 * /questionnaire/overTest
 * 
 * @author admin 问卷类
 */
@Controller
@RequestMapping("/questionnaire/")
public class QuestionnaireController {
	@Autowired
	private QuestionnaireService questionnaireService;

	/*
	 * 处理问卷的创建请求
	 */
	@ResponseBody
	@RequestMapping(value = "create")
	public Result createQuestionnare(@RequestBody Questionnaire questionnaire) {

		System.out.println(questionnaire);
		questionnaireService.addQuestionnaireService(questionnaire);
		return Result.success("创建成功");
	}

	/*
	 * 获取当前用户的完整试卷内容
	 */
	@ResponseBody
	@RequestMapping("getUserQuestionnaire")
	public Result getUserQuestionnaire(HttpServletRequest request) {
		Integer id = IdUtil.getQuestionnaireId(request);
		QuestionnaireTest questionnaireTest = questionnaireService.getQuestionAndOptions(id);
		return Result.success(questionnaireTest);
	}

	/*
	 * 获取当前的试卷信息
	 */
	@ResponseBody
	@RequestMapping("getMessage")
	public Result getQuestionnaireMessage() {
		Questionnaire questionnaire = questionnaireService.getQuestionnaireMessage();
		return Result.success();
	}

	/*
	 * 获取用户提交的试卷
	 */
	@ResponseBody
	@RequestMapping("papers")
	public Result doPapers(@RequestBody QuestionnaireTest qt, HttpServletRequest request) {
		Integer questionnaireId = IdUtil.getQuestionnaireId(request);
		Integer userId = IdUtil.getUserId(request);
		System.out.println("问卷Id：" + questionnaireId);
		System.out.println("用户Id:" + userId);
		boolean verify = questionnaireService.verResult(questionnaireId, userId);
		if (verify)
			return Result.success("不可重复提交");
		questionnaireService.disResult(qt,userId);

		/*
		 * 用户提交试卷信息 考题信息和答案信息集合 questionnaireId List<result>{questionId,optionId}
		 */
		return Result.success("交卷成功");
	}

	@ResponseBody
	@RequestMapping("overTest")
	public List<QuestionAndOptions> getOverTest(HttpServletRequest request) {
		Integer questionnaireId = IdUtil.getQuestionnaireId(request);
		Integer userId = IdUtil.getUserId(request);
		List<QuestionAndOptions> qaos = questionnaireService.getAllOptionsById(questionnaireId, userId);
		return qaos;
	}

	@ResponseBody
	@RequestMapping("userSum")
	public Result doSum(HttpServletRequest request) {
		Integer questionnaireId = IdUtil.getQuestionnaireId(request);
		Integer userId = IdUtil.getUserId(request);
		Integer sum = questionnaireService.getSum(questionnaireId, userId);
		return Result.success(sum);
	}
}
