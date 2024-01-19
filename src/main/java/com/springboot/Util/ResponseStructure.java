package com.springboot.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStructure<T> {

	private String msg;
	private int httpCode;
	private Object data;
	
}
