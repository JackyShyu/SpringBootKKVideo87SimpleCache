package org.shyu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class SpringBootKkVideo87SimpleCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKkVideo87SimpleCacheApplication.class, args);
	}
	
	// Replace by two lines in application.properties file:
	//	spring.cache.cache-names=ticketsCache
	//	# if spring.cache.type=none, means not using cache
	//	spring.cache.type=simple
	/*@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("ticketsCache");
	}*/
}
