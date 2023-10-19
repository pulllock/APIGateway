package fun.pullock.agw.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.Callable;

public class CompositeCache implements org.springframework.cache.Cache {

    private String name;

    private int timeout;

    private RedisTemplate redisTemplate;

    private CacheManager ehCacheManager;

    public CompositeCache(String name, int timeout, RedisTemplate redisTemplate, CacheManager ehCacheManager) {
        this.name = name;
        this.timeout = timeout;
        this.redisTemplate = redisTemplate;
        this.ehCacheManager = ehCacheManager;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return null;
    }

    @Override
    public ValueWrapper get(Object key) {
        Cache ehCache = ehCacheManager.getCache(name);
        String realKey = String.format("%s-%s", name, key);
        Element element = ehCache.get(realKey);
        if (element != null) {
            return element::getObjectValue;
        }

        Object redisValue = redisTemplate.opsForValue().get(realKey);

        if (redisValue != null) {
            ehCache.put(new Element(realKey, redisValue));
            return () -> redisValue;
        }

        return null;
    }

    @Override
    public <T> T get(Object key, Class<T> aClass) {
        return (T) get(key).get();
    }

    @Override
    public <T> T get(Object key, Callable<T> callable) {
        return (T) get(key).get();
    }

    @Override
    public void put(Object key, Object value) {
        Cache ehCache = ehCacheManager.getCache(name);
        String realKey = String.format("%s-%s", name, key);
        Element element = ehCache.get(realKey);
        if (element == null) {
            element = new Element(realKey, value);
        }
        ehCache.put(element);

        redisTemplate.opsForValue().set(realKey, value);
    }

    @Override
    public void evict(Object key) {

    }

    @Override
    public void clear() {

    }
}
