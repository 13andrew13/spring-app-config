package andrew.prog.springporject.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.*;

import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import javax.sql.DataSource;


@Configuration
@EnableSocial
@PropertySource ("classpath:application.properties")
public class SocialConfig implements SocialConfigurer {





    @Override
    public void addConnectionFactories (ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        connectionFactoryConfigurer.addConnectionFactory (new FacebookConnectionFactory (environment.getProperty ("spring.social.facebook.appId"),
                environment.getProperty ("spring.social.facebook.appSecret")));
    }

    @Override
    public UserIdSource getUserIdSource () {
        return ()->"";
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository (ConnectionFactoryLocator connectionFactoryLocator) {
        UsersConnectionRepository repository = new InMemoryUsersConnectionRepository (connectionFactoryLocator);
        return repository;
    }
    @Bean
    @Scope (value="request", proxyMode= ScopedProxyMode.INTERFACES)
    public Facebook facebook(ConnectionRepository repository) {
        Connection<Facebook> connection = repository.findPrimaryConnection(Facebook.class);
        return connection != null ? connection.getApi() : null;
    }



}
