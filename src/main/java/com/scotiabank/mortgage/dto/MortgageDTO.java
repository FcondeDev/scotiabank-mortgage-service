package com.scotiabank.mortgage.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MortgageDTO implements Serializable {
	private static final long serialVersionUID = 2787582565398897209L;
	@Min(value = 0)
	@ApiModelProperty(notes = "The down payment on the mortgage loan, numerical and positive", example = "10000")
	private Double downPayment;
	@ApiModelProperty(notes = "The home/property purchase price", example = "360000")
	private Double propertyPurchasePrice;
	@ApiModelProperty(notes = "The annual interest rate as percentage", example = "2.69")
	private Double annualInterestRate;
	@Max(value = 30)
	@ApiModelProperty(notes = "The lenght of loan in years, it cannot be higher than 30", example = "15")
	private Integer loanLength;

	@Override
	public String toString() {
		return "MortgageDTO [downPayment=" + downPayment + ", propertyPurchasePrice=" + propertyPurchasePrice
				+ ", annualInterestRate=" + annualInterestRate + ", loanLength=" + loanLength + "]";
	}

}
