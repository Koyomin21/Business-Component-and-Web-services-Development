package kz.iitu.itse1909.borangaziyev.exceptions;

import com.sun.jdi.InternalException;
import jdk.jshell.spi.ExecutionControl;
import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
        Exception ex = new InternalException("Something");
        ResponseEntity<ErrorMessage> result = restResponseEntityExceptionHandler.somethingWentWrong(ex);

        Assertions.assertEquals("<400 BAD_REQUEST Bad Request,ErrorMessage(message=Something, details=What else do you want to add),[]>", result.toString());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme