package com.oracle.service;

import com.oracle.dto.VarTimeSeriesDTO;
import com.oracle.entities.RiskMarketData;
import com.oracle.repository.RiskMarketDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<VarTimeSeriesDTO> getVarTimeSeries() {
    	List<RiskMarketData> dataList = riskRepo.findAllByOrderByReportingDate();
    	List<VarTimeSeriesDTO> result = new ArrayList<>();

    	for (RiskMarketData data : dataList) {
    		if (data.getStddev() != null && data.getZFactor() != null && data.getTimeHorizon() > 0) {
    			BigDecimal t = BigDecimal.valueOf(Math.sqrt(data.getTimeHorizon()));
    			BigDecimal var = data.getZFactor().multiply(data.getStddev()).multiply(t).multiply(data.getPortfolioValue());
    			var = var.setScale(2, RoundingMode.HALF_UP);
    			result.add(new VarTimeSeriesDTO(data.getReportingDate(), data.getPortfolioValue(), var));
    		}
    	}
    	return result;
    }
}
