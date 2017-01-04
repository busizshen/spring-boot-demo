package com.ecej.boot.demo.config;

import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 提供基础数据源功能
 * 
 * @author QIANG
 *
 */
@Configuration
public abstract class AbstractDruidDBConfig {

	private Logger logger = LoggerFactory.getLogger(AbstractDruidDBConfig.class);

	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;

	@Value("${druid.initialSize}")
	private int initialSize;

	@Value("${druid.minIdle}")
	private int minIdle;

	@Value("${druid.maxActive}")
	private int maxActive;

	@Value("${druid.maxWait}")
	private int maxWait;

	@Value("${druid.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;

	@Value("${druid.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;

	@Value("${druid.validationQuery}")
	private String validationQuery;

	@Value("${druid.testWhileIdle}")
	private boolean testWhileIdle;

	@Value("${druid.testOnBorrow}")
	private boolean testOnBorrow;

	@Value("${druid.testOnReturn}")
	private boolean testOnReturn;

	@Value("${druid.filters}")
	private String filters;

	@Value("{druid.connectionProperties}")
	private String connectionProperties;

	public DruidDataSource createDataSource(String url, String username, String password) {

		if (StringUtils.isEmpty(url)) {
			System.out.println(
					"Your database connection pool configuration is incorrect!" + " Please check your Spring profile");
			throw new ApplicationContextException("Database connection pool is not configured correctly");
		}

		DruidDataSource datasource = new DruidDataSource();

		datasource.setUrl(url);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setDriverClassName(driverClassName);
		// configuration
		datasource.setInitialSize(initialSize);
		datasource.setMinIdle(minIdle);
		datasource.setMaxActive(maxActive);
		datasource.setMaxWait(maxWait);
		datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		datasource.setValidationQuery(validationQuery);
		datasource.setTestWhileIdle(testWhileIdle);
		datasource.setTestOnBorrow(testOnBorrow);
		datasource.setTestOnReturn(testOnReturn);
		try {
			datasource.setFilters(filters);
		} catch (SQLException e) {
			logger.error("druid configuration initialization filter", e);
		}
		datasource.setConnectionProperties(connectionProperties);

		return datasource;
	}
}
