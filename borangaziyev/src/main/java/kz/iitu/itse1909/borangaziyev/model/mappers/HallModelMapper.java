package kz.iitu.itse1909.borangaziyev.model.mappers;

import kz.iitu.itse1909.borangaziyev.model.HallModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HallModelMapper implements RowMapper<HallModel> {
    @Override
    public HallModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        HallModel hallModel = new HallModel();
        hallModel.setHallId(rs.getLong("hallId"));
        hallModel.setCapacity(rs.getInt("capacity"));
        hallModel.setName(rs.getString("name"));

        return hallModel;
    }
}
