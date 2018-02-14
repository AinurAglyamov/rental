package my.classes.service;

import my.classes.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> productsList();
    Product findById(int id);
    void addProduct(Product product);
    void updateProduct(Product product);
    void removeProduct(int id);
}
