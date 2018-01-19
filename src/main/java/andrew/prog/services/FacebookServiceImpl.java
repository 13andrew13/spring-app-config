package andrew.prog.services;

import andrew.prog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FacebookServiceImpl implements FacebookService {
    @Autowired
    private Facebook facebookTemplate;


    @Override

    public User getUser () {
        org.springframework.social.facebook.api.User user = facebookTemplate.userOperations ().getUserProfile ();
        return new User (user.getFirstName (),user.getLastName (),"12341",user.getEmail (), LocalDateTime.now ());
    }
}
