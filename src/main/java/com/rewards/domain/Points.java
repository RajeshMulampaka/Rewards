package com.rewards.domain;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Points {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Long pointsEarned;
	private Date calculatedDate;
	
	@ManyToOne
	private Customer customer;
	
	@OneToOne
	private Transaction transaction;
	
	public Points(){
		
	}

	public Points(Long pointsEarned, Date calculatedDate, Customer customer, Transaction transaction ) {
		super();
		this.pointsEarned = pointsEarned;
		this.calculatedDate = calculatedDate;
		this.customer = customer;
		this.transaction = transaction;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPointsEarned() {
		return pointsEarned;
	}

	public void setPointsEarned(Long pointsEarned) {
		this.pointsEarned = pointsEarned;
	}

	public Date getCalculatedDate() {
		return calculatedDate;
	}

	public void setCalculatedDate(Date calculatedDate) {
		this.calculatedDate = calculatedDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Points [id=" + id + ", pointsEarned=" + pointsEarned + ", calculatedDate=" + calculatedDate + "]";
	}

}
