package com.cbc.bank.repository;

import com.cbc.bank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByCustomerUsername(String username);
}
