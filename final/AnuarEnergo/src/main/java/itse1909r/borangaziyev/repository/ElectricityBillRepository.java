package itse1909r.borangaziyev.repository;

import itse1909r.borangaziyev.model.ElectricityBill;
import itse1909r.borangaziyev.model.mapper.ElectricityBillMapper;
import itse1909r.borangaziyev.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ElectricityBillRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ElectricityBillRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ElectricityBill> getAllElectricityBills() {
        return jdbcTemplate.query(
                "SELECT * FROM ElectricityBill;",
                new ElectricityBillMapper()
        );
    }
}
