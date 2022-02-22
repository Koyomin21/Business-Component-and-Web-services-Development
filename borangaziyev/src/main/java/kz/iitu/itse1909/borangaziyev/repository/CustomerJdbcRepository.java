package kz.iitu.itse1909.borangaziyev.repository;


import kz.iitu.itse1909.borangaziyev.model.CustomerModel;
import kz.iitu.itse1909.borangaziyev.model.mappers.CustomerModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CustomerJdbcRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<CustomerModel> getAllCustomers() {
        String sql = "SELECT c.* FROM Customer c";
        return jdbcTemplate.query(sql, new CustomerModelMapper());
    }

    public List<CustomerModel> getVipCustomersFromSessionByMovieId(long id) {
        return null;
    }
}
