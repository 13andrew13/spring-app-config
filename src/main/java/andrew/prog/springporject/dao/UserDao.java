package andrew.prog.springporject.dao;

import andrew.prog.springporject.model.User;

public interface UserDao {
    User addUser (User user);
    User finUserById(Long id);
}
