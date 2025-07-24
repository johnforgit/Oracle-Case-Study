package com.oracle.repository;

import com.oracle.entities.MaturingCashFlow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaturingCashFlowRepository extends CrudRepository<MaturingCashFlow, Integer> {

@Query("SELECT m.bucket.label, " +
"SUM(CASE WHEN m.inflowOrOutflow = 'inflow' THEN m.amount ELSE 0 END), " +
"SUM(CASE WHEN m.inflowOrOutflow = 'outflow' THEN m.amount ELSE 0 END) " +
"FROM MaturingCashFlow m GROUP BY m.bucket.label ORDER BY m.bucket.bucketId")
List<Object[]> getLiquidityGapsByBucket();
}
