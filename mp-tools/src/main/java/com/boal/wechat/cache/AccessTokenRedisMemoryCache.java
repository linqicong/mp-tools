package com.boal.wechat.cache;

import com.boal.wechat.response.AccessTokenResponse;

/**
 * AccessToken的Redis内存缓存。
 *
 * @author Boal Lin
 * @since 2.0
 */
public class AccessTokenRedisMemoryCache extends RedisMemoryCache {

    /**
     * 构造函数。
     *
     * @param host     Redis服务端地址。
     * @param port     Redis服务端端口。
     * @param timeout  Redis服务端超时时间。
     * @param password Redis服务端密码。
     * @param database Redis服务端数据库。
     */
    public AccessTokenRedisMemoryCache(
            String host,
            int port,
            int timeout,
            String password,
            int database) {
        super(host, port, timeout, password, database);
    }

    /**
     * 获取处理后的键名。
     *
     * @param key 键名。
     * @return 处理后的键名。
     */
    private String redisKey(String key) {
        return AccessTokenRedisMemoryCache.class.getName() + "." + key;
    }

    /**
     * 通过键名获取AccessToken实例。
     *
     * @param key 键名。
     * @return AccessToken实例。
     */
    public AccessTokenResponse get(String key) {
        return (AccessTokenResponse) super.getValue(AccessTokenResponse.class, redisKey(key));
    }

    /**
     * 通过键名保存AccessTokenResponse实例。
     *
     * @param key    键名。
     * @param object AccessTokenResponse实例。
     */
    public void set(String key, AccessTokenResponse object) {
        super.setValue(redisKey(key), object);
    }

    /**
     * 通过键名移除AccessTokenResponse实例。
     *
     * @param key 键名。
     */
    public void remove(String key) {
        super.removeValue(redisKey(key));
    }

}
