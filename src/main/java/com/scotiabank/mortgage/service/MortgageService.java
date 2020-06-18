package com.scotiabank.mortgage.service;

import com.scotiabank.mortgage.dto.JsonDTO;
import com.scotiabank.mortgage.dto.MortgageDTO;
import com.scotiabank.mortgage.dto.MortgageResponseDTO;

public interface MortgageService {

	public JsonDTO<MortgageResponseDTO> calculatePaymentValue(MortgageDTO mortgageDTO);

}
