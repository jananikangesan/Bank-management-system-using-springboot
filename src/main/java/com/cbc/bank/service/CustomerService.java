package com.cbc.bank.service;

import com.cbc.bank.model.Customer;
import com.cbc.bank.repository.CustomerRepository;
import com.cbc.bank.utils.BankUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
       
   public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
    
   public ResponseEntity<String> updatePassword(String username,String currentPassword,String newPassword) {
		
		try {
			Customer cust=customerRepository.findByCustomerUsername(username);
			
			if(cust!=null && cust.getCustomerPassword().equals(currentPassword)) {
				cust.setCustomerPassword(newPassword);
				customerRepository.save(cust);
				 return BankUtils.getResponseEntity("Customer Password updated sucessfully", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return BankUtils.getResponseEntity("Wrong customer username or Password", HttpStatus.INTERNAL_SERVER_ERROR);
	}
   
   
    public ResponseEntity<String> transferFund( String senderUsername,  Integer receiverAccountNo, float amount) {
		
    	try {
    		Customer findSenderAccount=customerRepository.findByCustomerUsername(senderUsername);
    		Customer findReceiverAccount=customerRepository.findById(receiverAccountNo).orElse(null);
    		
    		float senderBalance=findSenderAccount.getCustomerBalance()-amount;
    		
    		if(findSenderAccount!=null && findReceiverAccount!=null && senderBalance>0) {
    			findSenderAccount.setCustomerBalance(senderBalance);
    			customerRepository.save(findSenderAccount);
    			
    			float receiverBalance=findReceiverAccount.getCustomerBalance()+amount;
    			findReceiverAccount.setCustomerBalance(receiverBalance);
    			customerRepository.save(findReceiverAccount);
    			return BankUtils.getResponseEntity("Fund was transfered successfully.", HttpStatus.OK);
    			
    		}else if(findReceiverAccount==null) {
    			return BankUtils.getResponseEntity("Wrong Receiver Account number. Enter correct Account Number.", HttpStatus.INTERNAL_SERVER_ERROR);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return BankUtils.getResponseEntity("You have insufficient balance to transfer fund.", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
