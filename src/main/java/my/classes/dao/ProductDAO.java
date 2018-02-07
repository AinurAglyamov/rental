package my.classes.dao;

import my.classes.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    /*Product findById(int id);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);*/

}
