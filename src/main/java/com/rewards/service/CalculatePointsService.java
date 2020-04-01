package com.rewards.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rewards.domain.Customer;
import com.rewards.domain.Points;
import com.rewards.domain.Transaction;
import com.rewards.repository.CustomerRepository;
import com.rewards.repository.PointsRepository;
import com.rewards.repository.TransactionRepository;

@Service
public class CalculatePointsService {
	
	private static final Logger log = LoggerFactory.getLogger(CalculatePointsService.class);
	
	private static final String FAILED = "FAILED!";
	private static final String SUCCESS = "SUCCESSFUL!";
	private static final BigDecimal HUNDRED = new BigDecimal(100);
	private static final BigDecimal FIFTY = new BigDecimal(50);
	private static final BigDecimal FACTOR1 = new BigDecimal(1);
	private static final BigDecimal FACTOR2 = new BigDecimal(2);
	@Autowired
	private TransactionRepository transactionRepo;
	@Autowired
	private PointsRepository pointsRepo;
	@Autowired
	private CustomerRepository customerRepo;
	
	@Transactional
	public String calPoints(){
		String result = FAILED;
		int calculatedPoints = 0;
		Points p = null;
		
		try{
			for(Transaction trans: transactionRepo.findAll()){
				calculatedPoints = calculateLogic(trans.getAmount().setScale(0, RoundingMode.FLOOR));
				Optional<Customer> cust = customerRepo.findById(trans.getCustomer().getId());
				if(cust.isPresent()) {
					Customer custPresent = cust.get();
					p = new Points(Long.valueOf(calculatedPoints), trans.getTransDate(), custPresent, trans);
				}
				pointsRepo.save(p);
				
				log.info(trans.toString() + "CalcPoints:" + calculatedPoints);
			}
			result = SUCCESS;
		}
		catch(Exception e){
			log.error("Error during the batch run." + e.getLocalizedMessage());
		}
		
		return result;
	}
	
	private int calculateLogic(BigDecimal amount) {
		int points = 0;
		BigDecimal remainingAmt;
		if( amount.compareTo(HUNDRED) < 0) {
			
			if(amount.compareTo(FIFTY) > 0){
				remainingAmt = amount.subtract(FIFTY);
				points = remainingAmt.multiply(FACTOR1).intValue();
			}
			
		}
		else {
			remainingAmt = amount.subtract(HUNDRED);
			points = FIFTY.multiply(FACTOR1).intValue() + remainingAmt.multiply(FACTOR2).intValue();
		}
		
		return points;
	}
	

}
