package com.oracle.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oracle.entities.Asset;

@Repository
public interface AssetRepository extends CrudRepository<Asset, Integer> {

    @Query("SELECT COALESCE(SUM(a.assetValue), 0) FROM Asset a WHERE a.isRateSensitive = true")
    BigDecimal getTotalRateSensitiveAssets();
}
