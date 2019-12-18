package com.rst.vo;

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
public class Result {
	private Integer status;// 定义状态码200正常
	private String message;// 服务器回复客户端的消息
	private Object data;// 服务器返回客户端的数据

	public static Result success() {
		return new Result(200, null, null);
	}
	public static Result success(Object obj) {
		return new Result(200, null, obj);
	}
	public static Result success(String msg) {
		return new Result(200, msg, null);
	}

	public static Result success(String msg, Object obj) {
		return new Result(200, msg, obj);
	}

	public static Result fail(String msg) {
		return new Result(201, msg, null);
	}
	public static Result fail() {
		return new Result(201, null, null);
	}
}
