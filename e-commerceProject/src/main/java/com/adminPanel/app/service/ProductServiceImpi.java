package com.adminPanel.app.service;

import com.adminPanel.app.dao.DaoImpi;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductServiceImpi implements ProductService {

    @Autowired
    DaoImpi  daoImpi;

    @Override
    public List<Product> getAll() {
        return daoImpi.getProducts();
    }

    @Override
    public void delete(int id) {

        daoImpi.deleteById(id);
    }

    @Override
    public void update(ProductDetails productDetails) {
        daoImpi.updateById(productDetails);
    }

    @Override
    public void create(ProductDetails productDetails) {
        validation(productDetails);
        Product product = new Product(productDetails.getName());
        productDetails.setProduct_id(product);
        daoImpi.addProduct(productDetails);
    }

    @Override
    public Product get(int id) {
        return daoImpi.getProductById(id);
    }
    private void validation(ProductDetails product) {
        if (product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        if (product.getPrice() <= 0) {
            throw new IllegalArgumentException("Product price must be greater than zero.");
        }

        List<Product> existingProducts = daoImpi.getProducts();
        for (Product p : existingProducts) {
            if (p.getName().equalsIgnoreCase(product.getName()) &&
                    (product.getId() == 0 || p.getId() != product.getId())) {
                throw new IllegalArgumentException("Product name must be unique.");
            }
        }
    }
}
