package com.oracle.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oracle.entities.DurationMetric;

@Repository
public interface DurationMetricRepository extends CrudRepository<DurationMetric, Integer> {

@Query("SELECT COALESCE(AVG(d.durationValue), 0) FROM DurationMetric d WHERE d.asset IS NOT NULL AND d.reportingDate = :date")
BigDecimal getTotalAssetDuration(LocalDate date);

@Query("SELECT COALESCE(AVG(d.durationValue), 0) FROM DurationMetric d WHERE d.liability IS NOT NULL AND d.reportingDate = :date")
BigDecimal getTotalLiabilityDuration(LocalDate date);
}

