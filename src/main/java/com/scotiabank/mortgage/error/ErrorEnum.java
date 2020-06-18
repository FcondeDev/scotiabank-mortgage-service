package com.scotiabank.mortgage.error;

public enum ErrorEnum {
	VALIDATION_CONSTRAINT_DOWNPAYMENT(1, "The down payment information is incorrect",
			"Only numerical and positives values are accepted"),
	VALIDATION_CONSTRAINT_LOAN(2, "The loan length information is incorrect",
			"The years of loan cannot be more than 30"),
	VALIDATION_CONSTRAINT_DOWNPAYMENT_PROPERTYPURCHASE(3, "The down payment information is incorrect",
			"The downPayment cannot be higher than 10% of property purchase price");

	public final int code;
	public final String title;
	public final String description;

	ErrorEnum(int code, String title, String description) {
		this.code = code;
		this.title = title;
		this.description = description;
	}
}
