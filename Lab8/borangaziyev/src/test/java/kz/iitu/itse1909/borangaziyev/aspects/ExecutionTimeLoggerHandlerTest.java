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


}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme