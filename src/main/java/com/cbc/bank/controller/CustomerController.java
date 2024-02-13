package com.cbc.bank.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.bank.Service.CustomerService;
import com.cbc.bank.model.Customer;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200/")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;


	@GetMapping("/showAllCustomer")
	List<Customer> ShowAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	@PutMapping(path="/updateCustomerPassword")
	public String updateCustomerPassword(@RequestParam String username,@RequestBody Map<String, String> requestBody) {
	    //String username = requestBody.get("username");
	    String currentPassword = requestBody.get("currentPassword");
	    String newPassword = requestBody.get("newPassword");
	    return customerService.updatePassword(username, currentPassword, newPassword);
	}
	
	@PutMapping(path="/fundTransfer")
	public String fundTransfer(@RequestParam Integer senderAccountNo, @RequestParam Integer receiverAccountNo,@RequestParam float amount) {
		return customerService.transferFund(senderAccountNo, receiverAccountNo, amount);
	}
}
