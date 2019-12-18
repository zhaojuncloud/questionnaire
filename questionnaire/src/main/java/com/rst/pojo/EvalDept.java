package com.rst.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EvalDept {
	private Integer id;// 类目细则id
	private Integer evalTypeId;// 类目id
	private String evalCon;// 类目细则详情
}
