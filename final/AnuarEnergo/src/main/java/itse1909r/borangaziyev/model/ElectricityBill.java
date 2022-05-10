package itse1909r.borangaziyev.model;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class ElectricityBill {
    private int billId;
    private int userId;
    private int unit;
    private LocalDate startPeriod;
    private LocalDate endPeriod;
    private int totalSum;

}
