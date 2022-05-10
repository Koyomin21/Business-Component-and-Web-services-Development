package itse1909r.borangaziyev.model;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Rate {
    private int rateId;
    private int pricePerUnit;
    private int providerId;
    private String description;
    private String rateTypeName;
}
