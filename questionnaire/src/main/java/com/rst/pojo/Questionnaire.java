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
public class Questionnaire {
	private Integer id;// 问卷id
	private String questionnaireName;//问卷名称
	private String questionnaireModel;// 考评模式
	private Integer questionnaireCycle;// 考评周期 1,2,3
	private Integer state=0;// 状态信息 0,1
	private Date createTime;// 创建时间
	private List<Integer> questionsId;//问卷问题
}
