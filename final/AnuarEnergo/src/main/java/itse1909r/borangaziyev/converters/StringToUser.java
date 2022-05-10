package itse1909r.borangaziyev.converters;


import itse1909r.borangaziyev.model.User;
import org.springframework.core.convert.converter.Converter;

public class StringToUser implements Converter<String, User> {

    @Override
    public User convert(String source) {
        User user = new User();
        String[] data = source.split(",");

        user.setUserId(Integer.valueOf(data[0].trim()));
        user.setUsername(data[1].trim());
        user.setPassword(data[2].trim());
        user.setFirstName(data[3].trim());
        user.setLastName(data[4].trim());

        return user;
    }
}
