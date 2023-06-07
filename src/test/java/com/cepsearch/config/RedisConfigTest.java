package com.cepsearch.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class RedisConfigTest {

    @Test
    public void testJedisConnectionFactory() {
	RedisConfig redisConfig = new RedisConfig();
	JedisConnectionFactory jedisConnectionFactory = redisConfig.jedisConnectionFactory();

	assertNotNull(jedisConnectionFactory);
    }

    @Test
    public void testRedisTemplate() {
	RedisConfig redisConfig = new RedisConfig();
	JedisConnectionFactory jedisConnectionFactoryMock = Mockito.mock(JedisConnectionFactory.class);
	RedisTemplate<String, Object> redisTemplate = redisConfig.redisTemplate();

	redisTemplate.setConnectionFactory(jedisConnectionFactoryMock);

	assertEquals(jedisConnectionFactoryMock, redisTemplate.getConnectionFactory());
    }

}
