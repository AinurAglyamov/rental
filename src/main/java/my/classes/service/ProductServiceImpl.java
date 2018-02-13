package my.classes.service;

import my.classes.dao.ProductDAO;
import my.classes.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService{
    private ProductDAO productDAO;

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> productsList() {
        return productDAO.findAll();
    }


    public Product findById(int id) {
        return productDAO.findById(id);
    }


    public void addProduct(Product product) {
         productDAO.addProduct(product);
    }

    /*@Override
    public Product findByTitle(String title) {
        Product product = productDAO.findByTitle(title);
        return product;
    }*/
}
