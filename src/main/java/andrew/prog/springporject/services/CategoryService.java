package andrew.prog.springporject.services;

import andrew.prog.springporject.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById (Long id);
}
