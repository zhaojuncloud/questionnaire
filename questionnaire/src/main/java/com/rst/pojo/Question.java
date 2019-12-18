package com.rst.pojo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors
public class Question {
	private Integer id; // 问题id
	private String questCon; // 问题描述
	private String createUser; // 创建者
	private Integer type; // 类型
	private Integer evalDeptId;// 问题类目
	private Date createTime;// 创建时间
	private Date updateTime;// 更新时间
	private List<Option> options;// 选项
}
