package andrew.prog.springporject.dao;

import andrew.prog.springporject.model.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao{
    @Autowired
    SessionFactory sessionFactory;


    @Override
    @SuppressWarnings ("unchecked")
    public List<Category> findAll () {
        return sessionFactory.getCurrentSession ().createQuery ("from Category").list ();
    }

    @Override
    public Category findById (Long id) {
        return sessionFactory.getCurrentSession ().find (Category.class,id);
    }
}
