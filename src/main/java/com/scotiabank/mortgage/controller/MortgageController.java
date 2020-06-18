package com.scotiabank.mortgage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scotiabank.mortgage.dto.JsonDTO;
import com.scotiabank.mortgage.dto.MortgageDTO;
import com.scotiabank.mortgage.dto.MortgageResponseDTO;
import com.scotiabank.mortgage.service.MortgageService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MortgageController {

	@Autowired
	private MortgageService mortgageService;

	@PostMapping("mortgages")
	@ApiOperation(value = "Calculate the customer's total monthly mortage payment value", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "the customer's total monthly mortage payment value"),
			@ApiResponse(code = 400, message = "The input data is wrong") })
	public ResponseEntity<JsonDTO<MortgageResponseDTO>> store(@Valid @RequestBody MortgageDTO mortgageDTO) {
		return new ResponseEntity<>(mortgageService.calculatePaymentValue(mortgageDTO), HttpStatus.OK);
	}

}
