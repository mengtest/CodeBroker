package com.codebroker.redis.collections.builder.impl;

import java.util.Map;

import com.codebroker.redis.collections.MapStructure;
import com.codebroker.redis.collections.builder.AbstractExpirable;
import com.codebroker.redis.collections.builder.RedisMap;
import com.codebroker.redis.collections.builder.RedisUtils;

import redis.clients.jedis.Jedis;

public class MapStructureImpl<T> extends AbstractExpirable<T> implements MapStructure<T> {

	public MapStructureImpl(Jedis jedis, String nameSpace, Class<T> clazz) {
		super(jedis, clazz, nameSpace);
	}

	@Override
	public Map<String, T> get(String key) {
		return new RedisMap<T>(jedis, clazz, RedisUtils.createKeyWithNameSpace(key, nameSpace));
	}

	@Override
	public void delete(String key) {
		jedis.del(RedisUtils.createKeyWithNameSpace(key, nameSpace));
	}

}
