package com.msa.manager.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.msa.manager.dao", sqlSessionTemplateRef = "sqlSessionTemplateDB1")
public class MyBatisConfig {

    @Bean(name = "sqlSessionTemplateDB1")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    @Bean(name = "sqlSessionFactoryDB1")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceDB1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:/mybatis/mybatis-config.xml"));
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/test/**/*.xml"));
        return sessionFactoryBean.getObject();
    }

    @Bean(name = "dataSourceDB1")
    @ConfigurationProperties(prefix = "spring.datasource.db1") // Configuration properties for the second database
    public DataSource dataSourceDB1() {
        return DataSourceBuilder.create().build();
    }

//    @Bean
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setName("jpubtestdb")
//                .setType(EmbeddedDatabaseType.HSQL)
//                .addScript("schema-hsqldb.sql")
//                .addScript("data-hsqldb.sql")
//                .build();
//    }

}
