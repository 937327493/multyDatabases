package cn.wzw.multydatabases.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(
        basePackages = "cn.wzw.multydatabases.tmsmapper",
        sqlSessionFactoryRef = "tmsSqlSessionFactory",
        sqlSessionTemplateRef = "tmsSqlSessionTemplate"
)
public class TmsMulConfiguration {
    @Qualifier("tmsDateSource")
    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory tmsSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mappers/tms/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }



    @Bean
    public SqlSessionTemplate tmsSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(tmsSqlSessionFactory());
    }



}
