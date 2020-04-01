package com.rewards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rewards.domain.Customer;
import com.rewards.domain.ResultSetForCustomerDTO;
import com.rewards.domain.ResultSetForMonthDTO;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	
	@Query(value = "Select CONCAT_WS('-', MONTH(p.calculated_date),YEAR(p.calculated_date)) as date, c.id as customerId, CONCAT_WS(' ', c.first_name, c.last_name) as customerName, sum(points_earned) pointsEarnedPerMonth " +
	               "from points p, customer c " +
			       "where p.customer_id = c.id " + 
	               "group by CONCAT_WS('-', MONTH(p.calculated_date),YEAR(p.calculated_date)), c.id ", nativeQuery = true)
	public List<ResultSetForMonthDTO> getCustomersPointsByMonth();

	@Query(value = "Select c.id as customerId, CONCAT_WS(' ', c.first_name, c.last_name) as customerName, sum(points_earned) totalPointsEarned  " +
                   "from points p, customer c " +
		           "where p.customer_id = c.id " + 
                   "group by c.id ", nativeQuery = true)
	public List<ResultSetForCustomerDTO> getPointsForEachCustomer();

}
