package com.codebroker.redis.collections;

import java.util.List;

/**
 * 键值对
 * 
 * @author xl
 *
 * @param <T>
 */
public interface keyValueRedisStructure<T> {

	T get(String key);

	void set(String key, T bean);

	List<T> multiplesGet(Iterable<String> keys);

	void delete(String key);
}
