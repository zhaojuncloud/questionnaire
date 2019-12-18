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
public class ResultPo {
private Integer id;
private Integer questionId;
private Integer optionsId;
private Integer userId;
private Date createTime;
private Integer questionnaireId;
private Integer score;
}
