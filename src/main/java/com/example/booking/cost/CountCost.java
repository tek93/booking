package com.example.booking.cost;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;
@Component
public class CountCost {


    public BigDecimal CountCost(LocalDate startDate, LocalDate endDate, BigDecimal unitCost){
        long days =  DAYS.between(startDate, endDate);
        BigDecimal cost =  unitCost.multiply(BigDecimal.valueOf(days));
        return cost;

    }
}
