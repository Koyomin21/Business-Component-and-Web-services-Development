package kz.iitu.itse1909.borangaziyev.repository;


import kz.iitu.itse1909.borangaziyev.database.MovieSession;
import kz.iitu.itse1909.borangaziyev.model.CustomerModel;
import kz.iitu.itse1909.borangaziyev.model.MovieSessionModel;
import kz.iitu.itse1909.borangaziyev.model.mappers.CustomerModelMapper;
import kz.iitu.itse1909.borangaziyev.model.mappers.MovieSessionModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CustomerJdbcRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<CustomerModel> getAllCustomers() {
        String sql = "SELECT c.* FROM Customer c";
        return jdbcTemplate.query(sql, new CustomerModelMapper());
    }


    public CustomerModel getCustomerById(long id) {
        String sql = "SELECT * FROM Customer WHERE customerId = :id";
        return jdbcTemplate.queryForObject(
                sql,
                new MapSqlParameterSource().addValue("id", id),
                new CustomerModelMapper()
        );
    }

    public int[] batchUpdateVipStatus(boolean vipStatus) {
        String sql = "UPDATE Customer SET isVip = :vipStatus WHERE customerId = :id";
        List<MapSqlParameterSource> params = new ArrayList<MapSqlParameterSource>();

        for(CustomerModel c: getAllCustomers()) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("vipStatus", vipStatus);
            source.addValue("id", c.getCustomerId());

            params.add(source);
        }

        int []updateCounts = jdbcTemplate.batchUpdate(
                sql,
                params.toArray(MapSqlParameterSource[]::new)
        );

        return updateCounts;
    }
//    public List<CustomerModel> getCustomersByBookingId(long id) {
//        String sql =    "SELECT * FROM Customer c " +
//                        "INNER JOIN Booking b on b.customerId = c.customerId " +
//                        "WHERE b.bookingId = id";
//
//        return jdbcTemplate.query(
//                sql,
//                new MapSqlParameterSource().addValue("id", id),
//                new CustomerModelMapper()
//        );
//    }
}
