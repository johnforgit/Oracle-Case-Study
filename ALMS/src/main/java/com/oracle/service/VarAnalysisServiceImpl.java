package com.oracle.service;

import com.oracle.entities.RiskMarketData;
import com.oracle.repository.RiskMarketDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class VarAnalysisServiceImpl implements VarAnalysisService {

    @Autowired
    private RiskMarketDataRepository riskRepo;

    @Override
    public BigDecimal calculateVaR(LocalDate reportingDate) {
        RiskMarketData data = riskRepo.findByReportingDate(reportingDate);

        if (data == null) return BigDecimal.ZERO;

        BigDecimal z = data.getZFactor();
        BigDecimal stddev = data.getStddev();
        BigDecimal time = BigDecimal.valueOf(Math.sqrt(data.getTimeHorizon()));
        BigDecimal portfolio = data.getPortfolioValue();

        return z.multiply(stddev)
                .multiply(time)
                .multiply(portfolio)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
