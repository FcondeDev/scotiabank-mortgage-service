package com.scotiabank.mortgage.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.scotiabank.mortgage.error.ErrorEnum;
import com.scotiabank.mortgage.exception.CustomException;

@Component
public class Utils {

	public void checkDownPaymentAndPropertyPurchasePrice(Double downPayment, Double propertyPurchasePrice) {

		if (downPayment > (0.10 * propertyPurchasePrice))
			throw new CustomException(ErrorEnum.VALIDATION_CONSTRAINT_DOWNPAYMENT_PROPERTYPURCHASE,
					HttpStatus.BAD_REQUEST, ErrorEnum.VALIDATION_CONSTRAINT_DOWNPAYMENT_PROPERTYPURCHASE.description);

	}

}
