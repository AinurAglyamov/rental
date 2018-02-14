package my.classes.service;

import my.classes.dao.CategoryDAO;
import my.classes.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO;

    @Autowired
    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public Category findById(int id) {
        return categoryDAO.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }


}
