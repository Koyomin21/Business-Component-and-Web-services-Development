package itse1909r.borangaziyev.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class DebtRate {
    private int debtId;
    private String rateName;
    private int addedPricePerUnit;
}
