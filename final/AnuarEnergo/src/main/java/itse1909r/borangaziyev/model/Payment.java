package itse1909r.borangaziyev.model;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class Payment {

    private int paymentId;
    private int userId;
    private String accountNumber;
    private LocalDate paymentDate;

}
