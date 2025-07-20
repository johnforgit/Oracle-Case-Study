package com.oracle.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oracle.entities.InterestIncomeExpense;
import com.oracle.entities.InterestIncomeExpense.EntryType;

@Repository
public interface InterestIncomeExpenseRepository extends CrudRepository<InterestIncomeExpense, Integer> {

    @Query("SELECT COALESCE(SUM(i.amount), 0) FROM InterestIncomeExpense i " +
           "WHERE i.entryType = :type AND i.period BETWEEN :startDate AND :endDate")
    BigDecimal getTotalByTypeAndPeriod(EntryType type, LocalDate startDate, LocalDate endDate);
}
