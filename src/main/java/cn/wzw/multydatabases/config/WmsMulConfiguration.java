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
        basePackages = "cn.wzw.multydatabases.wmsmapper",
        sqlSessionFactoryRef = "wmsSqlSessionFactory",
        sqlSessionTemplateRef = "wmsSqlSessionTemplate"
)
public class WmsMulConfiguration {

    @Resource(name = "wmsDateSource")
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory wmsSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mappers/wms/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }



    @Bean
    public SqlSessionTemplate wmsSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(wmsSqlSessionFactory());
    }

}
