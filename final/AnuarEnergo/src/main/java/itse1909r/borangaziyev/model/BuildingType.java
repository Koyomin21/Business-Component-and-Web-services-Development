package itse1909r.borangaziyev.model;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class BuildingType {
    private int buildingTypeId;
    private String name;
    private int rateId;
}
