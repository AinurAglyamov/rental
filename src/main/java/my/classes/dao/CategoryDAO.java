package my.classes.dao;

import my.classes.model.Category;

import java.util.List;

public interface CategoryDAO {
    Category findById(int id);
    List<Category> findAll();
}
