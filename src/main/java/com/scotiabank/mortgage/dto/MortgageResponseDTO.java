package com.scotiabank.mortgage.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MortgageResponseDTO implements Serializable {
	private static final long serialVersionUID = -8114625032193162008L;
	private Double value;
	private boolean success;

}
