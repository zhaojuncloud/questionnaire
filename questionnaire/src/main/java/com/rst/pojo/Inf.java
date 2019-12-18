package com.rst.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inf {
	private int num; //题目编号
	private String username; //创建者
	private String des;	//题干
}
