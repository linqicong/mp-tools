package com.boal.wechat.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.util.SafeEncoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Redis内存缓存。
 *
 * @author Boal
 * @since 2.0
 */
public class RedisMemoryCache {

    private JedisPool pool;

    /**
     * 构造函数。
     *
     * @param host     Redis服务端地址。
     * @param port     Redis服务端端口。
     * @param timeout  Redis服务端超时时间。
     * @param password Redis服务端密码。
     * @param database Redis服务端数据库。
     */
    public RedisMemoryCache(
            String host,
            int port,
            int timeout,
            String password,
            int database) {
        JedisPoolConfig config = new JedisPoolConfig();
        pool = new JedisPool(config, host, port, timeout, password, database);
    }

    /**
     * 通过键名获取一个实例。
     *
     * @param clazz 实例的类型。
     * @param key   键名。
     * @return 实例。
     */
    public Object getValue(Class clazz, String key) {
        try (Jedis jedis = pool.getResource()) {
            byte[] bytes = jedis.get(key.getBytes());
            if (bytes == null) {
                return null;
            } else {
                Object object = null;
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    object = objectInputStream.readObject();
                    byteArrayInputStream.close();
                    objectInputStream.close();
                } catch (Exception ignored) {
                }
                return object;
            }
        }
    }

    /**
     * 通过键名储存一个实例。
     *
     * @param key    键名。
     * @param object 实例。
     */
    public void setValue(String key, Object object) {
        try (Jedis jedis = pool.getResource()) {
            byte[] bytes = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(object);
                bytes = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                objectOutputStream.close();
            } catch (Exception ignored) {
            }
            if (bytes != null) {
                jedis.set(SafeEncoder.encode(key), bytes);
            }
        }
    }

    /**
     * 通过键名移除一个实例。
     *
     * @param key 键名。
     */
    public void removeValue(String key) {
        try (Jedis jedis = pool.getResource()) {
            jedis.del(key);
        }
    }
    /**
     * 设置一个值的有效期。
     *
     * @param key 键名。
     * @param time 过期时间。
     */
    public void expireAt(String key,long time) {
        try (Jedis jedis = pool.getResource()) {
            jedis.expireAt(key,time);
        }
    }
    /**
     * 设置一个值的有效期。
     *
     * @param key 键名。
     * @param second 秒。
     */
    public void expire(String key,int second) {
        try (Jedis jedis = pool.getResource()) {
            jedis.expire(key,second);
        }
    }
}
