package com.rst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rst.dao.QuestionMapper;
import com.rst.pojo.Question;
import com.rst.service.QuestionService;
import com.rst.vo.Result;

@RestController
@RequestMapping("/question/")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@RequestMapping("getAllQuestion")
	public Result getAllQuestion() {
		List<Question> questions=questionService.getAllQuestion();
		return Result.success(questions);
	}
	@RequestMapping("createQuestion")
	public Result createQuestion(@RequestBody Question question)
	{
		questionService.createQuestion(question);
		return Result.success("创建成功");
	}
}
