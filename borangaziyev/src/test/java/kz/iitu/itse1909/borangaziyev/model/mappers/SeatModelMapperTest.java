package kz.iitu.itse1909.borangaziyev.model.mappers;

import kz.iitu.itse1909.borangaziyev.model.SeatModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SeatModelMapperTest {
    SeatModelMapper seatModelMapper = new SeatModelMapper();

    @Test
    void testMapRow() throws SQLException {
        ResultSet rs = mock(ResultSet.class);

        when(rs.getLong("seatId")).thenReturn(1l);
        when(rs.getInt("row")).thenReturn(3);
        when(rs.getInt("number")).thenReturn(5);
        when(rs.getInt("hallId")).thenReturn(2);

        SeatModel seatModel = new SeatModel();
        seatModel.setSeatId(rs.getLong("seatId"));
        seatModel.setRow(rs.getInt("row"));
        seatModel.setNumber(rs.getInt("number"));
        seatModel.setHallId(rs.getInt("hallId"));


        SeatModel result = seatModelMapper.mapRow(rs, 0);
        Assertions.assertEquals(seatModel, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme