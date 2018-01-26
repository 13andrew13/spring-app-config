package andrew.prog.springporject.dao;

import andrew.prog.springporject.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
/*    @Autowired
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
}*/
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User addUser (User user) {
        sessionFactory.getCurrentSession ().persist (user);
        return user;
    }

    @Override
    public User finUserById (Long id) {
        String hql = "from User u join Order O where O.id=:id";
        User user = (User) sessionFactory.getCurrentSession ().createQuery (hql).setParameter ("id",id).uniqueResult ();

/*        User user = sessionFactory.getCurrentSession ().get (User.class,id);
        return user;*/
        return user;
    }
}
