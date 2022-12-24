package cn.wzw.multydatabases.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author wangziwei
 */
@Configuration
public class DataSourceConfiguration {
    @Bean
    public DataSource tmsDateSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .username("root")
                .password("root")
                .url("jdbc:mysql://127.0.0.1:3306/people")
                .build();
    }

    @Bean
    public DataSource wmsDateSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .username("root")
                .password("root")
                .url("jdbc:mysql://127.0.0.1:3306/white_register")
                .build();
    }

}
