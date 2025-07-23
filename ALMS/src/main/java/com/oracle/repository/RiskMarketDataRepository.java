package com.oracle.repository;

import com.oracle.entities.RiskMarketData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RiskMarketDataRepository extends CrudRepository<RiskMarketData, Integer> {

    @Query("SELECT r FROM RiskMarketData r WHERE r.reportingDate = :reportingDate")
    RiskMarketData findByReportingDate(LocalDate reportingDate);
    
    @Query("SELECT r FROM RiskMarketData r ORDER BY r.reportingDate")
    List<RiskMarketData> findAllByOrderByReportingDate();
}
