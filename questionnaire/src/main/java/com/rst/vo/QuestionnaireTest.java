package com.rst.vo;

import java.util.List;

import com.rst.pojo.Questionnaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors
@ToString
public class QuestionnaireTest {
private Questionnaire questionnaire;
private List<QuestionAndOptions> qaos;
}
