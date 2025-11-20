package com.adminPanel.app.service;

import com.adminPanel.app.dao.ProductDaoImpl;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductServiceImpi implements ProductService {

    @Autowired
    ProductDaoImpl daoImpi;

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
        Product product = new Product(productDetails.getName());
        productDetails.setProduct_id(product);
        daoImpi.addProduct(productDetails);
    }

    @Override
    public Product get(int id) {
        return daoImpi.getProductById(id);
    }
}
