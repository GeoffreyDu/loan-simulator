package fr.formation.simulator.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface LoanSimulationViewDto {
    Long getId();
    BigDecimal getAmount();
    BigDecimal getLoanRate();
    String getLoanType();
    BigDecimal getInsuranceRate();
    BigDecimal getDuration();
    LocalDate getStartDate();
}
