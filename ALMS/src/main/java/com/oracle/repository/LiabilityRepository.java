package com.oracle.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oracle.entities.Liability;

@Repository
public interface LiabilityRepository extends CrudRepository<Liability, Integer> {

    @Query("SELECT COALESCE(SUM(l.liabilityValue), 0) FROM Liability l WHERE l.isRateSensitive = true")
    BigDecimal getTotalRateSensitiveLiabilities();
    @Query("SELECT COALESCE(SUM(l.liabilityValue), 0) FROM Liability l")
    BigDecimal getTotalLiabilityValue();

}
