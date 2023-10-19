package fun.pullock.agw.cache;

import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Arrays;

@Configuration
@EnableCaching
public class CacheConfig {

    @Resource
    private RedisTemplate redisTemplate;

    @Bean
    public CacheManager cacheManager() {
        final SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        String apiByCode = "apiByCode";
        int apiByCodeTime = 60 * 5;

        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        final CacheConfiguration apiByCodeCacheConfiguration = new CacheConfiguration();
        apiByCodeCacheConfiguration.setName(apiByCode);
        apiByCodeCacheConfiguration.setMaxEntriesLocalHeap(10000);
        apiByCodeCacheConfiguration.setTimeToLiveSeconds(apiByCodeTime);
        config.addCache(apiByCodeCacheConfiguration);
        net.sf.ehcache.CacheManager ehCacheManager = net.sf.ehcache.CacheManager.newInstance(config);


        CompositeCache compositeCache = new CompositeCache(apiByCode, apiByCodeTime, redisTemplate, ehCacheManager);
        simpleCacheManager.setCaches(Arrays.asList(compositeCache));
        return simpleCacheManager;
    }



}
