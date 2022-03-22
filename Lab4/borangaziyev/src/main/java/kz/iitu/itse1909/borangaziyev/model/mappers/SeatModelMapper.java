package kz.iitu.itse1909.borangaziyev.model.mappers;

import kz.iitu.itse1909.borangaziyev.model.SeatModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatModelMapper implements RowMapper<SeatModel> {


    @Override
    public SeatModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        SeatModel seatModel = new SeatModel();
        seatModel.setSeatId(rs.getLong("seatId"));
        seatModel.setRow(rs.getInt("row"));
        seatModel.setNumber(rs.getInt("number"));
        seatModel.setHallId(rs.getInt("hallId"));

        return seatModel;
    }
}
