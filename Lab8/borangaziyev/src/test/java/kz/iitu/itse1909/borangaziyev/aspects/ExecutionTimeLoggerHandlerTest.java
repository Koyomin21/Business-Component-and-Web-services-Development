package kz.iitu.itse1909.borangaziyev.aspects;

import org.aspectj.internal.lang.reflect.SignaturePatternImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.util.GenericSignature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class ExecutionTimeLoggerHandlerTest {
    @Mock
    Logger log;
    @InjectMocks
    ExecutionTimeLoggerHandler executionTimeLoggerHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAllAnnotatedClassMethods() {
        executionTimeLoggerHandler.allAnnotatedClassMethods();
    }

    @Test
    void testAllRepositoryClassMethods() {
        executionTimeLoggerHandler.allRepositoryClassMethods();
    }

    @Test
    void testAllServiceClassMethods() {
        executionTimeLoggerHandler.allServiceClassMethods();
    }

    @Test
    void testLogExecutionTime() {
        ProceedingJoinPoint joinPoint = mock(ProceedingJoinPoint.class);
        MethodSignature signature = mock(MethodSignature.class);
        Method method = mock(Method.class);

        when(joinPoint.getSignature()).thenReturn(signature);
        when(signature.getMethod()).thenReturn(method);




        Object result = executionTimeLoggerHandler.logExecutionTime(joinPoint);
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme