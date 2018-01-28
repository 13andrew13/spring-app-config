package andrew.prog.springporject.services;

import andrew.prog.springporject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FacebookServiceImpl implements FacebookService{

        @Autowired
        private Facebook facebookTemplate;


        @Override
        public User getUser () {
            String fields[] = {"email","first_name","last_name"};
            org.springframework.social.facebook.api.User user = facebookTemplate.fetchObject ("me", org.springframework.social.facebook.api.User.class,fields);
            return new User (user.getFirstName (),user.getLastName (),"12341",user.getEmail (), LocalDateTime.now ());
        }

}
