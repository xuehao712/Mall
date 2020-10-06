package com.shawn.mall.common.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Redis operating service
 */
public interface RedisService {
    /**
     * Save property
     */
    void set(String key,Object value, long time);
    /**
     * Save property
     */
    void set(String key,Object value);
    /**
     * Get property
     */
    Object get(String key);
    /**
     * Delete property
     */
    Boolean del(String key);
    /**
     * Multiple delete property
     */
    Long del(List<String> keys);
    /**
     * Set expiration time
     */
    Boolean expire(String key, long time);
    /**
     * Get expiration time
     */
    Long getExpire(String key);
    /**
     * Determine if has property
     */
    Boolean hasKey(String key);
    /**
     * Increment by delta
     */
    Long incr(String key, long delta);
    /**
     * Decrement by delta
     */
    Long decr(String key, long delta);
    /**
     * Get hash property
     */
    Object hGet(String key,String hashKey);
    /**
     * Put hash property
     */
    Boolean hSet(String key, String hashKey, Object value, long time);
    /**
     * Put hash property
     */
    void hSet(String key, String hashKey, Object value);
    /**
     * Get all hash
     */
    Map<Object,Object> hGetAll(String key);
    /**
     * Set all hash
     */
    Boolean hSetAll(String key,Map<String,Object> map,long time);
    /**
     * Set all hash
     */
    void hSetAll(String key,Map<String,?> map);
    /**
     * Delete hash property
     */
    void hDel(String key, Object... hashKey);
    /**
     * Determine hash has property
     */
    Boolean hHasKey(String key, String hashKey);
    /**
     * Hash increment
     */
    Long hIncr(String key,String hashKey,Long delta);
    /**
     * Hash decrement
     */
    Long hDecr(String key, String hashKey, Long delta);
    /**
     * Get set structure
     */
    Set<Object> sMembers(String key);
    /**
     * Add set property
     */
    Long sAdd(String key,Object... values);
    /**
     * Add set property
     */
    Long sAdd(String key,long time, Object... values);
    /**
     * Whether set property
     */
    Boolean sIsMember(String key,Object value);
    /**
     * Get set size
     */
    Long sSize(String key);
    /**
     * Delete set property
     */
    Long sRemove(String key,Object... values);
    /**
     * Get list property
     */
    List<Object> lRange(String key, long start,long end);
    /**
     * Get list size
     */
    Long lSize(String key);
    /**
     * Get list property base on index
     */
    Object lIndex(String key, long index);
    /**
     * Add property to list
     */
    Long lPush(String key,Object value);
    /**
     * Add property to list
     */
    Long lPush(String key, Object value, long time);
    /**
     * Add multiple property to list
     */
    Long lPushAll(String key, Object... values);
    /**
     * Add multiple property to list
     */
    Long lPushAll(String key, Long time,Object... values);
    /**
     * Delete property from list
     */
    Long lRemove(String key,long count,Object value);
}
