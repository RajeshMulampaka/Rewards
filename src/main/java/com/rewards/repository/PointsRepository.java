package com.rewards.repository;

import org.springframework.data.repository.CrudRepository;

import com.rewards.domain.Points;

public interface PointsRepository extends CrudRepository<Points, Long> {

}
