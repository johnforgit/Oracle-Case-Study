package com.oracle.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.entities.InterestIncomeExpense.EntryType;
import com.oracle.repository.AssetRepository;
import com.oracle.repository.InterestIncomeExpenseRepository;

@Service
public class NimAnalysisServiceImpl implements NimAnalysisService {

    @Autowired
    private InterestIncomeExpenseRepository interestRepo;

    @Autowired
    private AssetRepository assetRepo;

    @Override
    public BigDecimal calculateNIM(LocalDate startDate, LocalDate endDate) {
        BigDecimal income = interestRepo.getTotalByTypeAndPeriod(EntryType.INCOME, startDate, endDate);
        BigDecimal expense = interestRepo.getTotalByTypeAndPeriod(EntryType.EXPENSE, startDate, endDate);
        BigDecimal avgAssets = assetRepo.getAverageEarningAssets();

        if (avgAssets == null || avgAssets.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        return income.subtract(expense).divide(avgAssets, 6, BigDecimal.ROUND_HALF_UP);
    }
}
