package com.cbc.bank.Service;

import com.cbc.bank.model.Customer;
import com.cbc.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
       
   public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
    
    public String updatePassword(String username,String password) {
		Customer cust=customerRepository.findByCustomerUsername(username);
	
		if(cust!=null) {
			cust.setCustomerPassword(password);
			customerRepository.save(cust);
			return "Customer password updated successfully.";
		}
		return "Wrong customer username. Enter the correct username.";
	}
    public String transferFund( Integer senderAccountNo,  Integer receiverAccountNo, float amount) {
		
		Customer findSenderAccount=customerRepository.findById(senderAccountNo).orElse(null);
		Customer findReceiverAccount=customerRepository.findById(receiverAccountNo).orElse(null);
		
		float senderBalance=findSenderAccount.getCustomerBalance()-amount;
		
		if(findSenderAccount!=null && findReceiverAccount!=null && senderBalance>0) {
			findSenderAccount.setCustomerBalance(senderBalance);
			customerRepository.save(findSenderAccount);
			
			float receiverBalance=findReceiverAccount.getCustomerBalance()+amount;
			findReceiverAccount.setCustomerBalance(receiverBalance);
			customerRepository.save(findReceiverAccount);
			
			return "Fund was transfered successfully.";
		}else if(findReceiverAccount==null) {
			return "Wrong Receiver Account number. Enter correct Account Number.";
		}
			
		return "You have insufficient balance to transfer fund.";

	}

}
