package com.rewards.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rewards.domain.ResultSetForCustomerDTO;
import com.rewards.domain.ResultSetForMonthDTO;
import com.rewards.repository.CustomerRepository;
import com.rewards.repository.PointsRepository;
import com.rewards.repository.TransactionRepository;

@Service
public class ReportsService {
	
	private static final Logger log = LoggerFactory.getLogger(ReportsService.class);
	
	@Autowired
	private TransactionRepository transactionRepo;
	@Autowired
	private PointsRepository pointsRepo;
	@Autowired
	private CustomerRepository customerRepo;
	
	@Transactional
	public List<ResultSetForMonthDTO> getCustPointByMonth(){
		return customerRepo.getCustomersPointsByMonth();
	}
	
	@Transactional
	public List<ResultSetForCustomerDTO> getPointsForEachCustomer(){
		return customerRepo.getPointsForEachCustomer();
	}
	
	@Transactional
	public void getCustTotalPoints(){
		
	}
	

}
