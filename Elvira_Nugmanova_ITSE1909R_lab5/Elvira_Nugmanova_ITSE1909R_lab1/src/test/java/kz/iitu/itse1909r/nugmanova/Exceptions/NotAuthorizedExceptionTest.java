//package kz.iitu.itse1909r.nugmanova.Exceptions;
//
//import kz.iitu.itse1909r.nugmanova.AOP.AuthorizationAspect;
//import kz.iitu.itse1909r.nugmanova.Service.AuthorizationService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
//class NotAuthorizedExceptionTest {
//    @Mock
//    Object backtrace;
//    @Mock
//    Throwable cause;
//    //Field stackTrace of type StackTraceElement - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
//    @Mock
//    List<Throwable> SUPPRESSED_SENTINEL;
//    @Mock
//    List<Throwable> suppressedExceptions;
//
//    @Mock
//    AuthorizationService service;
//    @InjectMocks
//    NotAuthorizedException notAuthorizedException;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testing() {
//        when(service.getCustomerByEmail(any()) == null).thenThrow(new NotAuthorizedException("A"));
//    }
//}
//
////Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme