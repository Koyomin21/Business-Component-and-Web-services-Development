package kz.iitu.itse1909.borangaziyev.validators.converters;

import kz.iitu.itse1909.borangaziyev.database.Hall;
import org.springframework.core.convert.converter.Converter;

public class StringToHallConverter implements Converter<String, Hall> {

    @Override
    public Hall convert(String source) {
        String []data = source.split(",");
        Hall hall = new Hall();
        hall.setHallId(Long.parseLong(data[0]));
        hall.setName(data[1]);
        hall.setCapacity(Integer.parseInt(data[2]));

        return hall;
    }
}
