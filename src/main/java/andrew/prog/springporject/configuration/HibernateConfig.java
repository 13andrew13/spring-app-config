package andrew.prog.springporject.configuration;


import org.hibernate.SessionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource ("classpath:application.properties")
public class HibernateConfig {
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource,Environment environment){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean ();
        sessionFactoryBean.setDataSource (dataSource);
        sessionFactoryBean.setPackagesToScan ("andrew.prog.springporject.model");
        sessionFactoryBean.setHibernateProperties (properties (environment));
        return sessionFactoryBean;
    }
    @Bean

    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager manager = new HibernateTransactionManager (sessionFactory);
        return manager;
    }


    private Properties properties(Environment environment){
        Properties properties = new Properties ();
        properties.put ("hibernate.show_sql",environment.getProperty ("show_sql"));
        properties.put ("hibernate.format_sql",environment.getProperty ("format_sql"));
        properties.put ("hibernate.dialect",environment.getProperty ("dialect"));
        properties.put ("hibernate.hbm2ddl.auto",environment.getProperty ("hbm2dll.auto"));
        properties.put ("hibernate.connection.driver_class",environment.getProperty ("connection.driver_class"));
        properties.put ("hibernate.connection.url",environment.getProperty ("connection.url"));
        properties.put ("hibernate.connection.password",environment.getProperty ("connection.password"));
        properties.put ("hibernate.connection.username",environment.getProperty ("connection.username"));
        return properties;

    }
}
