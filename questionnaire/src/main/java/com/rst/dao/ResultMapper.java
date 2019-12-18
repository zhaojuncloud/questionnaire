package com.rst.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rst.pojo.ResultPo;

public interface ResultMapper {
	void insertResult(ResultPo resultPo);
	List<ResultPo> verResult(@Param("questionnaireId") Integer questionnaireId,
			@Param("userId")Integer userId);
	Integer doSum(@Param("questionnaireId") Integer questionnaired,
			@Param("userId")Integer userId);
	List<Integer> getOptionsId(@Param("questionnaireId") Integer questionnaired,
			@Param("userId")Integer userId,
			@Param("questionId")Integer questionId); 
}
