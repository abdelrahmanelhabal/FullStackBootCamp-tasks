package com.adminPanel.app.service;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    void delete(int id);
    void update(ProductDetails product);
    void create(ProductDetails product);
    Product get(int id);
}
