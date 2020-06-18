package com.scotiabank.mortgage.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@AllArgsConstructor
public class ApiErrorDTO implements Serializable {

	private static final long serialVersionUID = 2194478515013966505L;
	private int code;
	private String title;
	private String description;

}
