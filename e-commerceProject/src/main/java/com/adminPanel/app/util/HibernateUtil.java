package com.adminPanel.app.util;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = build();
     static SessionFactory build() {
        try{
            Configuration configuration = new Configuration();
            configuration.configure()
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(ProductDetails.class);

            return configuration.buildSessionFactory();
        }catch(Exception e){
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed"+e);
        }
    }
    public static SessionFactory getSessionFactory() {
         return sessionFactory;
    }
    public static void shutdown() {
        sessionFactory.close();
    }
}
