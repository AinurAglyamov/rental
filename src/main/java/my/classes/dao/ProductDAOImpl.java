package my.classes.dao;

import my.classes.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Product> findAll() {
        List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
        return products;
    }

    @Transactional
    public Product findById(int id) {
        Product product = sessionFactory.getCurrentSession().load(Product.class, new Integer(id));
        return product;
    }

    /*@Transactional
    public Product findByTitle(String title){
        Product product = sessionFactory.getCurrentSession().createQuery("SELECT p FROM Product p WHERE p.title = :title");
        return product;
    }*/


    @Transactional
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT p FROM Product p WHERE p.title = :title");
        query.setParameter("title", product.getTitle());
        if(query.getSingleResult() == null){
            sessionFactory.getCurrentSession().persist(product);
        } else {
            System.out.println("Продукт уже есть");
        }
    }
}
