package andrew.prog.springporject.services;

import andrew.prog.springporject.dao.CategoryDao;
import andrew.prog.springporject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> findAll () {
        return categoryDao.findAll ();
    }

    @Override
    public Category findById (Long id) {
        return categoryDao.findById(id);
    }
}
