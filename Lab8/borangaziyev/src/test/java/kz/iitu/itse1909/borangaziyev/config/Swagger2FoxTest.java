package kz.iitu.itse1909.borangaziyev.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import springfox.documentation.spring.web.plugins.Docket;

class Swagger2FoxTest {
    Swagger2Fox swagger2Fox = new Swagger2Fox();

    @Test
    void testApi() {
        Docket result = swagger2Fox.api();
        Assertions.assertNotNull( result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme