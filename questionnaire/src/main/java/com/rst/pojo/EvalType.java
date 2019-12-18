package com.rst.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EvalType {
	private Integer id; // 类目id
	private String evalName;// 类目名称
	private List<EvalDept> evalDepts;// 子类目
}
