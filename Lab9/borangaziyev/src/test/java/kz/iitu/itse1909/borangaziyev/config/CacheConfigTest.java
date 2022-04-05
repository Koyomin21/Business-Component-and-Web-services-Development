package kz.iitu.itse1909.borangaziyev.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.cache.CacheManager;

class CacheConfigTest {
    CacheConfig cacheConfig = new CacheConfig();

    @Test
    void testCacheManager() {
        CacheManager result = cacheConfig.cacheManager();
        String res = result.toString();
        Assertions.assertEquals(res, result.toString());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme