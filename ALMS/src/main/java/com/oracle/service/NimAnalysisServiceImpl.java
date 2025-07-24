package com.oracle.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	
	public List<Map<String,String>> computeNIM() {
	
		List<Map<String,String>> avgAssets = assetRepo.getAverageActiveAssetsPerYear();
		List<Map<String,Double>> fetchedInterestIncomeExpense = interestRepo.getAnnualIncomeExpenseSummary();
		
		Map<String,String> map=new HashMap<>();
		List<Map<String,String>> returnData =new ArrayList<>();
		
		avgAssets.forEach(System.out::println);
		
		avgAssets
		.stream()
		.forEach((data)->{
			map.put(String.valueOf(data.get("maturity_year")), String.valueOf(data.get("cumulative_avg")));
		});
		

		
		fetchedInterestIncomeExpense
		.stream()
		.forEach((data)->{	
			Map<String,String> o=new HashMap<>();
			BigDecimal i=new BigDecimal(String.valueOf(data.get("income")));
			BigDecimal e=new BigDecimal(String.valueOf(data.get("expense")));
			BigDecimal avg=new BigDecimal(map.getOrDefault(String.valueOf(data.get("year")),"1"));
			o.put("year", String.valueOf(data.get("year")));
			o.put("income", i.toString());
			o.put("expense", e.toString());
			System.out.println(i);
			System.out.println(e);
			System.out.println(i.subtract(e));
//			System.out.println(i.subtract(e).divide(avg));
			System.out.println(10327.50/985714.2857);
			System.out.println(avg);
			o.put("nim", ((i.subtract(e)).divide(avg,8, RoundingMode.HALF_UP)).toString());
			returnData.add(o);
		});
		return returnData;
	}
}
