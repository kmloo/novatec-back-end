package co.com.novatec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class Datasource {

    @Bean(name = "dsBd")
    @ConfigurationProperties(prefix = "spring.datasource")
    public javax.sql.DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcBd")
    public JdbcTemplate slaveJdbcTemplate(@Qualifier("dsBd") javax.sql.DataSource dsSlave) {
        return new JdbcTemplate(dsSlave);
    }

    @Primary
    @Bean(name = "namedParameterJdbcTemplateMsBd")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplateOne(@Qualifier("dsBd") javax.sql.DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }

    @Bean(name = "txmBd")
    @Autowired
    @Primary
    DataSourceTransactionManager tmMotoViaje(@Qualifier("dsBd") javax.sql.DataSource ds) {
        DataSourceTransactionManager txm = new DataSourceTransactionManager(ds);
        return txm;
    }

}
