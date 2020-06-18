package com.scotiabank.mortgage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scotiabank.mortgage.dto.JsonDTO;
import com.scotiabank.mortgage.dto.MortgageDTO;
import com.scotiabank.mortgage.dto.MortgageResponseDTO;
import com.scotiabank.mortgage.helpers.Utils;
import com.scotiabank.mortgage.service.MortgageService;

import lombok.extern.java.Log;

@Service
@Log
public class MortgageServiceImpl implements MortgageService {

	@Autowired
	private Utils utils;

	@Override
	public JsonDTO<MortgageResponseDTO> calculatePaymentValue(MortgageDTO mortgageDTO) {
		utils.checkDownPaymentAndPropertyPurchasePrice(mortgageDTO.getDownPayment(),
				mortgageDTO.getPropertyPurchasePrice());

		log.info("---Starting Service---");

		log.info(String.format("Input information : %s ", mortgageDTO.toString()));

		Double r = mortgageDTO.getAnnualInterestRate() / 1200;
		Integer n = mortgageDTO.getLoanLength() * 12;
		Double p = mortgageDTO.getPropertyPurchasePrice() - mortgageDTO.getDownPayment();
		log.info(String.format("Monthly Interest Rate information : %s ", r));
		log.info(String.format("Number of Payments : %s ", n));
		log.info(String.format("Principal Loan Amount : %s ", p));

		Double value = p * (Math.pow((1 + r), n) * r) / (Math.pow((1 + r), n) - 1);

		log.info(String.format("Value : %s", value));
		log.info("---Finishing Service---");
		return new JsonDTO<>(new MortgageResponseDTO(value, true));
	}

}
