package com.rst;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rst.dao.OptionsMapper;
import com.rst.dao.QuestionMapper;
import com.rst.dao.QuestionnaireMapper;
import com.rst.dao.ResultMapper;
import com.rst.dao.UserMapper;
import com.rst.dao.UserQuestionnaireMapper;
import com.rst.pojo.Option;
import com.rst.pojo.Question;
import com.rst.pojo.Questionnaire;
import com.rst.pojo.User;
import com.rst.vo.Result;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {
	@Autowired
	private OptionsMapper mappr;
	@Autowired
	private QuestionMapper qestMapper;

	@Autowired
	private UserQuestionnaireMapper userQMapper;

	@Autowired
	private QuestionnaireMapper questionnaireMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ResultMapper resultMapper;

	@Test
	public void getUser() {
		User user = userMapper.getUserByUserName("1");
		System.out.println(user);
	}

	@Test
	public void testQuestion() {
		Question question = new Question();
		Date date=new Date();
		question.setQuestCon("测试题目");
		question.setType(1);
		question.setCreateUser("admin");
		question.setCreateTime(date);
		question.setEvalDeptId(111);
		question.setUpdateTime(date);
		qestMapper.createQuestion(question);
		System.out.println(question.getId());
	}

	@Test
	public void testUserQ() {
		List<Integer> result = userQMapper.getQuestionnaireIdById(1);
		System.out.println(result);
	}

	@Test
	public void testQuestionnaire() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4);

		List<Questionnaire> questionnaire = questionnaireMapper.getQuestionnaires(list);
		System.out.println(questionnaire);

	}

	@Test
	public void testResult() {
		Integer doSum = resultMapper.doSum(4, 1);
		System.out.println(doSum);
	}
}
