package com.inditex.pruebatecnica.configTest;

import com.inditex.pruebatecnica.config.CacheConfig;
import org.junit.jupiter.api.Test;
import org.springframework.cache.CacheManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The type Cache config test.
 */
class CacheConfigTest {

    /**
     * Should create cache manager.
     */
    @Test
    void shouldCreateCacheManager() {
        CacheConfig cacheConfig = new CacheConfig();
        CacheManager cacheManager = cacheConfig.cacheManager();

        assertNotNull(cacheManager);
    }
}
