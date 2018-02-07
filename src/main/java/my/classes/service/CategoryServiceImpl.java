package my.classes.service;

import my.classes.dao.CategoryDAO;
import my.classes.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO;

    @Autowired
    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }


    @Transactional
    public Category findById(int id) {
        return categoryDAO.findById(id);
    }
}
