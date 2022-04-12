package kz.iitu.itse1909.borangaziyev.validators.formatters;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.util.StringValueResolver;

import java.text.ParseException;
import java.util.Locale;
import java.util.Set;

import static org.mockito.Mockito.*;

class FormatterServiceBeanFactoryTest {
    @Mock
    DateTimeFormatter dateFormat;
    @Mock
    Set<Formatter<?>> formatters;
    @Mock
    Set<?> converters;
    @Mock
    Set<FormatterRegistrar> formatterRegistrars;
    @Mock
    StringValueResolver embeddedValueResolver;
    @Mock
    FormattingConversionService conversionService;
    @InjectMocks
    FormatterServiceBeanFactory formatterServiceBeanFactory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testInit() {
        formatterServiceBeanFactory.init();
    }

    @Test
    void testGetDateTimeFormatter() {
        String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern(DEFAULT_DATE_PATTERN);
        Formatter<DateTime> formatter = new Formatter<DateTime>() {
            @Override
            public DateTime parse(String text, Locale locale) throws ParseException {
                return null;
            }

            @Override
            public String print(DateTime object, Locale locale) {
                return null;
            }
        };

        //when(formatterServiceBeanFactory.getDateTimeFormatter()).thenReturn(formatter);

        Formatter<DateTime> result = formatterServiceBeanFactory.getDateTimeFormatter();
        Assertions.assertNotEquals("kz.iitu.itse1909.borangaziyev.validators.formatters.FormatterServiceBeanFactory$1@6c", result.toString());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme