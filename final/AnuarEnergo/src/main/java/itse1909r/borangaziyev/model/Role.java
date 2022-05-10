package itse1909r.borangaziyev.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Role {
    private int roleId;
    private String roleName;

}
