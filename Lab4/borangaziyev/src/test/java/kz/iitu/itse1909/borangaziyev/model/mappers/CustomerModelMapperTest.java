package kz.iitu.itse1909.borangaziyev.model.mappers;

import kz.iitu.itse1909.borangaziyev.model.CustomerModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerModelMapperTest {
    CustomerModelMapper customerModelMapper = new CustomerModelMapper();

    @Test
    void testMapRow() throws SQLException {
        ResultSet rs = mock(ResultSet.class);

        when(rs.getLong("customerId")).thenReturn(1l);
        when(rs.getString("firstName")).thenReturn("John");
        when(rs.getString("lastName")).thenReturn("Johnson");
        when(rs.getString("email")).thenReturn("John@mail.ru");
        when(rs.getBoolean("isVip")).thenReturn(false);

        CustomerModel customer = new CustomerModel();

        customer.setCustomerId(rs.getLong("customerId"));
        customer.setFirstName(rs.getString("firstName"));
        customer.setLastName(rs.getString("lastName"));
        customer.setEmail(rs.getString("email"));
        customer.setVip(rs.getBoolean("isVip"));

        CustomerModel result = customerModelMapper.mapRow(rs, 0);
        Assertions.assertEquals(customer, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme