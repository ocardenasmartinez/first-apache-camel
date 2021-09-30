package cl.martin.joaquin.configuration;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    private CamelContext camelContext;

    @Bean
    ProducerTemplate producerTemplate() {
        return camelContext.createProducerTemplate();
    }

    @Bean
    ConsumerTemplate consumerTemplate() {
        return camelContext.createConsumerTemplate();
    }

    /*@Bean
    @ConfigurationProperties(prefix="datasource1")
    public BasicDataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/postgres");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("tallo_123");
        return dataSourceBuilder.build();
    }*/

}
