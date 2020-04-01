package com.rewards.repository;

import org.springframework.data.repository.CrudRepository;

import com.rewards.domain.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
