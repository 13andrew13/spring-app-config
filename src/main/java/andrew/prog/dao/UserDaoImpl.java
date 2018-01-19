package andrew.prog.dao;

import andrew.prog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public User addUser(User user){
        String sql = "INSERT INTO USERS (ID, EMAIL, PASSWORD, FISRT_NAME, LAST_NAME, REGISTER_DATE) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update (sql,
                user.getId (),
                user.getEmail (),
                user.getPassword (),
                user.getFirstName (),
                user.getLastName (),
                user.getRegisterDate ().toString()
        );
        return user;
    }
}
