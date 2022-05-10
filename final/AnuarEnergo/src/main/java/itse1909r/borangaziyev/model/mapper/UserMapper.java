package itse1909r.borangaziyev.model.mapper;

import itse1909r.borangaziyev.model.User;
import org.springframework.jdbc.core.RowMapper;


import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User movie = new User();
        movie.setUserId(rs.getInt("userId"));
        movie.setUsername(rs.getString("username"));
        movie.setPassword(rs.getString("password"));
        movie.setFirstName(rs.getString("firstName"));
        movie.setLastName(rs.getString("lastName"));


        return movie;

    }
}
