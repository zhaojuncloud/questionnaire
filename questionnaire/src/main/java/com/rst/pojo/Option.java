package com.rst.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Option {
	private Integer id;// 选项id
	private Integer questionId;// 问题id
	private String optCon;// 选项描述
	private String createUser;// 创建者
	private Integer score;// 分数
	private Date createTime;// 创建时间
	private Date updateTime;// 更新时间
}
