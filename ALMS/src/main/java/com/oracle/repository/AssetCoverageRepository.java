package com.oracle.repository;

import com.oracle.entities.AssetCoverageComponent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetCoverageRepository extends CrudRepository<AssetCoverageComponent, Integer> {

    @Query("SELECT acc FROM AssetCoverageComponent acc WHERE acc.reportingDate = :reportingDate")
    AssetCoverageComponent findByReportingDate(java.time.LocalDate reportingDate);
}
