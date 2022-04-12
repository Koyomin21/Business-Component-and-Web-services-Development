package kz.iitu.itse1909.borangaziyev.validators.converters;

import kz.iitu.itse1909.borangaziyev.database.Hall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.converter.Converter;

class StringToHallConverterTest {
    StringToHallConverter stringToHallConverter = new StringToHallConverter();

    @Test
    void testConvert() {
        Hall result = stringToHallConverter.convert("source");
        Assertions.assertEquals(new Hall(), result);
    }

//    @Test
//    void testAndThen() {
//        Converter<String, U> result = stringToHallConverter.andThen(null);
//        Assertions.assertEquals(null, result);
//    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme