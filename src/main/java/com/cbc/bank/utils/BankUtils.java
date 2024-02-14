package com.cbc.bank.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BankUtils {

	 BankUtils(){}

	    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
	        return new ResponseEntity<String>("{\"message\" : \""+responseMessage+"\"}", httpStatus);
	    }
}
