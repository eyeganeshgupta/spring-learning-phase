package io.spring.repository;

import java.math.BigDecimal;

public interface FinancialInfoProjection {
    BigDecimal getBudget();
    BigDecimal getBoxOffice();
}
