package com.rewards.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.rewards.domain.Customer;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue
	private Long id;
	private String src;
	private BigDecimal amount;
	private Date transDate;
	
	@ManyToOne
	private Customer customer;
	
	public Transaction(){
		
	}
	
	

	public Transaction(String src, BigDecimal amount, Date transDate) {
		super();
		this.src = src;
		this.amount = amount;
		this.transDate = transDate;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", src=" + src + ", amount=" + amount + ", transDate=" + transDate + "]";
	}
	
}
