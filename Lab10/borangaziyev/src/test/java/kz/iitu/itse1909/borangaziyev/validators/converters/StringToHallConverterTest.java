package kz.iitu.itse1909.borangaziyev.validators.converters;

import kz.iitu.itse1909.borangaziyev.database.Hall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.converter.Converter;

class StringToHallConverterTest {
    StringToHallConverter stringToHallConverter = new StringToHallConverter();

    @Test
    void testConvert() {
        // Expected result
        Hall expected = new Hall();
        expected.setHallId(1);
        expected.setName("HallName");
        expected.setCapacity(120);


        Hall result = stringToHallConverter.convert("1,HallName,120");
        Assertions.assertEquals(expected, result);
    }

//    @Test
//    void testAndThen() {
//        Converter<String, U> result = stringToHallConverter.andThen(null);
//        Assertions.assertEquals(null, result);
//    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme