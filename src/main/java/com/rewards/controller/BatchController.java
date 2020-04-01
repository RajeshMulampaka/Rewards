package com.rewards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.domain.ResultSetForCustomerDTO;
import com.rewards.domain.ResultSetForMonthDTO;
import com.rewards.service.CalculatePointsService;
import com.rewards.service.ReportsService;

@RestController
public class BatchController {
	
	@Autowired
	private CalculatePointsService calcPointsService;
	
	@Autowired
	private ReportsService reportService;
	
	@GetMapping(value = "/runBatch")
	public String calc() {
		return calcPointsService.calPoints();
	}
	
	@GetMapping(value = "/runReportByMonth")
	public List<ResultSetForMonthDTO> reportByMonth() {
		return reportService.getCustPointByMonth();
	}
	
	@GetMapping(value = "/runReportByCustomer")
	public List<ResultSetForCustomerDTO> reportByCustomer() {
		return reportService.getPointsForEachCustomer();
	}

}
