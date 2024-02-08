package com.cbc.bank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cbc_customer_table")
public class Customer {
    @Id
    @Column(name="account_number")
    private int customerId;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="contact_number")
    private long customerNumber;

    @Column(name="username")
    private String customerUsername;

   
    @Column(name="password")
    private String customerPassword;

    @Column(name="balance")
    private float customerBalance;

    public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String customerName, long customerNumber, String customerUsername, String customerPassword, float customerBalance) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerUsername = customerUsername;
        this.customerPassword = customerPassword;
        this.customerBalance = customerBalance;
    }

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public float getCustomerBalance() {
		return customerBalance;
	}

	public void setCustomerBalance(float customerBalance) {
		this.customerBalance = customerBalance;
	}
}
