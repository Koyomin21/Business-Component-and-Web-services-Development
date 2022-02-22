package kz.iitu.itse1909.borangaziyev.model.mappers;

import kz.iitu.itse1909.borangaziyev.model.CustomerModel;
import kz.iitu.itse1909.borangaziyev.model.MovieModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerModelMapper implements RowMapper<CustomerModel> {


    @Override
    public CustomerModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        CustomerModel customer = new CustomerModel();
        customer.setCustomerId(rs.getLong("customerId"));
        customer.setFirstName(rs.getString("firstName"));
        customer.setLastName(rs.getString("lastName"));
        customer.setEmail(rs.getString("email"));
        customer.setVip(rs.getBoolean("isVip"));

        return customer;
    }
}
