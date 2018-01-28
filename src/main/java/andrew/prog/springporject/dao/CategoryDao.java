package andrew.prog.springporject.dao;

import andrew.prog.springporject.model.Category;
import andrew.prog.springporject.model.Product;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll();

    Category findById (Long id);
}
