package com.rst.dao;

import java.util.List;

import com.rst.pojo.Option;
import com.rst.pojo.ResultPo;

public interface OptionsMapper {
	List<Option> getOptionByQuestionId(Integer id);
	Option getOptionById(Integer id);
	void createOption(Option option);
}
