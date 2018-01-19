package andrew.prog.services;

import andrew.prog.dao.UserDao;
import andrew.prog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    UserDao userDao;

    @Override
    public User addUser (User user) {
        user.setPassword (encoder.encode (user.getPassword ()));
        user.setRegisterDate (LocalDateTime.now ());
        return userDao.addUser(user);
    }
}
