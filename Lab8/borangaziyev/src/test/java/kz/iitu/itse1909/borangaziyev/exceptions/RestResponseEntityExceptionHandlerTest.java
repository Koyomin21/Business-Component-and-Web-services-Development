package kz.iitu.itse1909.borangaziyev.exceptions;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

class RestResponseEntityExceptionHandlerTest {
    @Mock
    Log pageNotFoundLogger;
    @Mock
    Log logger;
    @InjectMocks
    RestResponseEntityExceptionHandler restResponseEntityExceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSomethingWentWrong() {

        Exception ex = mock(Exception.class);
        ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), "What else do you want to add");
        ResponseEntity<ErrorMessage> responseEntity =
                new ResponseEntity<ErrorMessage>(exceptionResponse, new HttpHeaders(),
                        HttpStatus.BAD_REQUEST);

        when(restResponseEntityExceptionHandler.somethingWentWrong(ex)).thenReturn(responseEntity);

        ResponseEntity<ErrorMessage> result = restResponseEntityExceptionHandler.somethingWentWrong(ex);
        Assertions.assertEquals(responseEntity, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme