package kz.iitu.itse1909.borangaziyev.model.mappers;

import kz.iitu.itse1909.borangaziyev.model.HallModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HallModelMapperTest {
    HallModelMapper hallModelMapper = new HallModelMapper();

    @Test
    void testMapRow() throws SQLException {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getLong("hallId")).thenReturn(1l);
        when(rs.getInt("capacity")).thenReturn(60);
        when(rs.getString("name")).thenReturn("Hall 1");


        HallModel hallModel = new HallModel();
        hallModel.setHallId(rs.getLong("hallId"));
        hallModel.setCapacity(rs.getInt("capacity"));
        hallModel.setName(rs.getString("name"));

        HallModel result = hallModelMapper.mapRow(rs, 0);
        Assertions.assertEquals(hallModel, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme