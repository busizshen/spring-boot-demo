package com.ecej.boot.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 提供基础配置加载功能
 * 
 * @author QIANG
 *
 */
@Configuration
@PropertySource(ignoreResourceNotFound = true, value = { "classpath:remote-db.properties",
		"classpath:remote-dubbo.properties", "classpath:remote-mq.properties", "classpath:remote-redis.properties",
		"classpath:remote-zk.properties" })
@ImportResource({ "classpath:dubbo/*.xml" })
public class PropertyConfig extends WebMvcConfigurerAdapter {

}
