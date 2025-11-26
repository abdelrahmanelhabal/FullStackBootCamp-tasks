package com.adminPanel.app.dao;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class ProductDaoImpl implements Dao{

    @Override
    public List<Product> getProducts() {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            return session.createQuery("from Product",Product.class).getResultList();
        }catch(Exception ex){
            throw new RuntimeException("Filed to list all products!!",ex);
        }
    }

    @Override
    public void deleteById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();

            Product product = session.get(Product.class, id);

            if (product == null){
                throw new RuntimeException("Product not found with id: " + id);
            }
            if (product.getProductDetails() == null){
                throw new RuntimeException("product details not found with product id: " + id);
            }

            Query query = session.createQuery("delete from Product where id=:i");
            query.setParameter("i",id);
            query.executeUpdate();

            session.getTransaction().commit();
        }catch(Exception ex){
            throw new RuntimeException("Filed to delete product!!",ex);
        }
    }

    @Override
    public void updateById(ProductDetails newProductDetails) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            int productDetailsId = newProductDetails.getId();

            if (productDetailsId == 0) {
                throw new RuntimeException("Invalid ProductDetails id: " + productDetailsId);
            }
            ProductDetails existingDetails = session.get(ProductDetails.class, productDetailsId);
            if (existingDetails == null) {
                throw new RuntimeException("ProductDetails not found with id: " + productDetailsId);
            }

            Product product = existingDetails.getProduct_id();
            if (product == null) {
                throw new RuntimeException("Associated Product is null for ProductDetails id: " + productDetailsId);
            }

            existingDetails.setName(newProductDetails.getName());
            existingDetails.setManufacturer(newProductDetails.getManufacturer());
            existingDetails.setPrice(newProductDetails.getPrice());
            existingDetails.setExpirationDate(newProductDetails.getExpirationDate());
            existingDetails.setAvailable(newProductDetails.getAvailable());
            product.setName(newProductDetails.getName());

            session.update(product);
            session.getTransaction().commit();
        }catch(Exception ex){
            System.out.println();
            throw new RuntimeException("Filed to update product!!",ex);
        }
    }

    @Override
    public void addProduct(ProductDetails product) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            session.persist(product);
            session.getTransaction().commit();
        }catch(Exception ex){
            throw new RuntimeException("Filed to add product!!",ex);
        }
    }

    @Override
    public Product getProductById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
           session.beginTransaction();
           return session.get(Product.class, id);
        }catch(Exception ex){
            throw new RuntimeException("Filed to find product!!",ex);
        }
    }

}
