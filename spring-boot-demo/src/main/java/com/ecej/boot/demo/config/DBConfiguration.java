package com.ecej.boot.demo.config;

import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

/**
 * 核心配置，配置数据源 事物 sqlsession
 * 
 * @author QIANG
 *
 */
@Configuration
public class DBConfiguration extends AbstractDruidDBConfig {

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	// 注册dataSource
	@Bean(name = "datasource", initMethod = "init", destroyMethod = "close")
	public DruidDataSource dataSource() {
		return super.createDataSource(url, username, password);
	}

	@Bean(name = "demoSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		// mybatis分页
		PageHelper pageHelper = new PageHelper();
		Properties props = new Properties();
		props.setProperty("dialect", "mysql");
		props.setProperty("reasonable", "true");
		props.setProperty("supportMethodsArguments", "true");
		props.setProperty("returnPageInfo", "check");
		props.setProperty("params", "count=countSql");
		pageHelper.setProperties(props); // 添加插件
		sqlSessionFactoryBean.setPlugins(new Interceptor[] { pageHelper });
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	// @Bean
	// public PlatformTransactionManager transactionManager() throws
	// SQLException {
	// return new DataSourceTransactionManager(dataSource());
	// }
}
