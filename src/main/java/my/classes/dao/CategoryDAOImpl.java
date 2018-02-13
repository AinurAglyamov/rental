package my.classes.dao;

import my.classes.model.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class CategoryDAOImpl implements CategoryDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional
    public Category findById(int id) {
        Category category = sessionFactory.getCurrentSession().load(Category.class, new Integer(id));
        //category.getId();
        return category;
    }


    @Transactional
    public List<Category> findAll() {
        List<Category> categories = sessionFactory.getCurrentSession().createQuery("from Category").list();
        return categories;
    }
}
