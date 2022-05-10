package itse1909r.borangaziyev.model.mapper;


import itse1909r.borangaziyev.model.ElectricityBill;
import itse1909r.borangaziyev.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ElectricityBillMapper implements RowMapper<ElectricityBill> {


    @Override
    public ElectricityBill mapRow(ResultSet rs, int rowNum) throws SQLException {
        ElectricityBill bill = new ElectricityBill();
        bill.setElectroBillId(rs.getInt("electroBillId"));
        bill.setUserId(rs.getInt("userId"));
        bill.setStartPeriod(rs.getDate("startPeriod").toLocalDate());
        bill.setEndPeriod(rs.getDate("endPeriod").toLocalDate());
        bill.setUnitsUsed(rs.getInt("unitsUsed"));
        bill.setTotalSum(rs.getInt("totalSum"));

        return bill;

    }
}
