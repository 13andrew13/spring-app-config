package my.prog;

import my.prog.dao.UserDao;
import my.prog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
