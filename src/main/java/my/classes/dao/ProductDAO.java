package my.classes.dao;

import my.classes.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    Product findById(int id);
    //Product findByTitle(String title);
    void addProduct(Product product);
    void updateProduct(Product product);
    void removeProduct(int id);
    /*
    void deleteProduct(int id);*/
    //

}
