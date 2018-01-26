package andrew.prog.springporject.services;

import andrew.prog.springporject.dao.UserDao;
import andrew.prog.springporject.model.Order;
import andrew.prog.springporject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public User addUser (User user) {
        user.setPassword (encoder.encode (user.getPassword ()));
        user.setRegisterDate (LocalDateTime.now ());
        userDao.addUser(user);
        return user;
    }
}
