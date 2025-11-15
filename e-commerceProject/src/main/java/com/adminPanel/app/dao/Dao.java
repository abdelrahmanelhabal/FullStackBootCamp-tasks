package com.adminPanel.app.dao;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import java.util.List;

public interface Dao {
    List<Product> getProducts();
    void deleteById(int id);
    void updateById(ProductDetails product);
    void addProduct(ProductDetails product);
    Product getProductById(int id);
}
