package andrew.prog.configuration;

import andrew.prog.model.User;
import andrew.prog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.*;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import javax.sql.DataSource;
import java.util.concurrent.atomic.AtomicLong;

@Configuration
@EnableSocial
@PropertySource ("classpath:application.properties")
public class SocialConfig implements SocialConfigurer {

    DataSource dataSource;

    @Autowired
    public SocialConfig (@Value ("#{dataSource}") DataSource dataSource) {
        this.dataSource = dataSource;
    }

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
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        repository.setConnectionSignUp (new ConnectionSignUp () {
            @Autowired
            UserService service;
            @Override
            public String execute (Connection<?> connection) {
                User user = new User();
                user.setFirstName (connection.getDisplayName ());
                user.setPassword("12431");
                //service.addUser (user);
                return "social";
            }
        });
        return repository;
    }
    @Bean
    @Scope (value="request", proxyMode= ScopedProxyMode.INTERFACES)
    public Facebook facebook(ConnectionRepository repository) {
        Connection<Facebook> connection = repository.findPrimaryConnection(Facebook.class);
        return connection != null ? connection.getApi() : null;
    }


    @Bean
    public Facebook facebookTemplate(Environment environment){
        return new FacebookTemplate (environment.getProperty ("spring.social.facebook.appId"),
                environment.getProperty ("spring.social.facebook.appSecret"));
    }
    @Bean
    public ConnectController connectController(ConnectionFactoryLocator factoryLocator,ConnectionRepository connectionRepository){
        return new ConnectController (factoryLocator,connectionRepository);
    }


}
