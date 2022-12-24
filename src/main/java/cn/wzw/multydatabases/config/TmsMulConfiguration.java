package cn.wzw.multydatabases.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author wangziwei
 */
@Configuration
@MapperScan(
        basePackages = "cn.wzw.multydatabases.tmsmapper",
        sqlSessionFactoryRef = "tmsSqlSessionFactory",
        sqlSessionTemplateRef = "tmsSqlSessionTemplate"
)
public class TmsMulConfiguration {
    @Resource(name = "tmsDateSource")
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
