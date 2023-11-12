package com.ecommerce.PaymentServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConfig {

//     @Bean
//     public DataSource getDataSource() {
//     final DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//     dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//     dataSourceBuilder.url("jdbc:mysql://ecommercedb.c25xj0lpmeiu.us-east-2.rds.amazonaws.com:3306/ecommercedb");
//     dataSourceBuilder.username("admin");
//     dataSourceBuilder.password("Ecommerce4413!");
//     return dataSourceBuilder.build();
//     }

//     @Bean
//     public DataSource dataSource() {
//          DriverManagerDataSource dataSource = new DriverManagerDataSource();
//          dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Empty driverClassName - This is causing the issue
//          dataSource.setUrl("jdbc:mysql://ecommercedb.c25xj0lpmeiu.us-east-2.rds.amazonaws.com:3306/ecommercedb");
//          dataSource.setUsername("admin");
//          dataSource.setPassword("Ecommerce4413!");
//          return dataSource;
//     }
private static final Logger log = LoggerFactory.getLogger(DatabaseConfig.class);

     @Value("${spring.datasource.url}")
     private String url;

     @Value("${spring.datasource.username}")
     private String username;

     @Value("${spring.datasource.password}")
     private String password;

     @Value("${spring.datasource.driver-class-name}")
     private String driverClassName;

     @Bean
     public DataSource dataSource() {
          DriverManagerDataSource dataSource = new DriverManagerDataSource();
          dataSource.setDriverClassName(driverClassName);
          dataSource.setUrl(url);
          dataSource.setUsername(username);
          dataSource.setPassword(password);
          return dataSource;
     }
//     @Autowired
//     Environment env;
//
//     @Bean
//     public DataSource dataSource() {
//          final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//          dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("driver-class-name")));
//          dataSource.setUrl(env.getProperty("url"));
//          dataSource.setUsername(env.getProperty("username"));
//          dataSource.setPassword(env.getProperty("password"));
//          return dataSource;
//     }

//    @Bean
//    public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }


}
