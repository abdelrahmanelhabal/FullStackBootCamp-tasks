package com.adminPanel.app.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Setter @Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "name")
    private String name ;

    @OneToOne(mappedBy = "product_id" ,cascade = CascadeType.ALL)
    private ProductDetails productDetails;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
