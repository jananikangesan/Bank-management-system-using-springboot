package com.cbc.bank.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.bank.model.Customer;
import com.cbc.bank.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200/")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	//http://localhost:8099/customer/showAllCustomer
	@GetMapping("/showAllCustomer")
	List<Customer> ShowAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	
	//http://localhost:8099/customer/updateCustomerPassword?username=janani
	@PutMapping(path="/updateCustomerPassword")
	public ResponseEntity<String> updateCustomerPassword(@RequestParam String username,@RequestBody Map<String, String> requestBody) {
	    //String username = requestBody.get("username");
	    String currentPassword = requestBody.get("currentPassword");
	    String newPassword = requestBody.get("newPassword");
	    return customerService.updatePassword(username, currentPassword, newPassword);
	}
	
	
	//http://localhost:8099/customer/fundTransfer?senderUsername=janani&receiverAccountNo=10002&amount=10000
	@PutMapping(path="/fundTransfer")
	public ResponseEntity<String>fundTransfer(@RequestParam String senderUsername, @RequestParam Integer receiverAccountNo,@RequestParam float amount) {
		return customerService.transferFund(senderUsername, receiverAccountNo, amount);
	}
}
