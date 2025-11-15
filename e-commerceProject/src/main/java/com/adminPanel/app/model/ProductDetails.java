package com.adminPanel.app.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "Product_details" )
@Setter @Getter
@NoArgsConstructor
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @NotBlank(message = "Name is required")
    @Column(name = "name")
    private String name ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product_id ;

    @NotNull(message = "Expiration date is required")
    @Future(message = "Expiration date must be in the Future")
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate ;

    @NotBlank(message = "Manufacturer is required")
    @Column(name = "manufacturer")
    private String manufacturer ;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Column(name = "price")
    double price ;

    @NotNull(message = "Availability is required")
    @Column(name = "available")
    private Boolean available ;

    public ProductDetails(Product product,String name , Date expirationDate, String manufacturer, double price, Boolean available) {
        this.product_id = product;
        this.name = name;
        this.expirationDate = expirationDate;
        this.manufacturer = manufacturer;
        this.price = price;
        this.available = available;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product_id=" + product_id +
                ", expirationDate=" + expirationDate +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
