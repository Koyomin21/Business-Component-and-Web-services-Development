//package kz.iitu.itse1909r.nugmanova.AOP;
//
//import kz.iitu.itse1909r.nugmanova.Database.Customer;
//import kz.iitu.itse1909r.nugmanova.Service.AuthorizationService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.core.env.Environment;
//
//import static org.mockito.Mockito.*;
//
//class AuthorizationAspectTest {
//    @Mock
//    AuthorizationService authorizationService;
//    @Mock
//    Environment environment;
//    @InjectMocks
//    AuthorizationAspect authorizationAspect;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testAuthorizationAnnotatedMethods() {
//        authorizationAspect.authorizationAnnotatedMethods();
//    }
//
//    @Test
//    void testAuthorize() {
//        when(authorizationService.getCustomerByEmail(anyString())).thenReturn(new Customer(null, "password"));
//
//        authorizationAspect.authorize(null);
//    }
//}
//
////Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme