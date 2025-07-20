package com.oracle.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface DurationGapService {
BigDecimal calculateDurationGap(LocalDate reportingDate);
}
