package com.hassware.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorder")
    private Integer idorder;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date;
    @Column(name = "customer")
    private String customer;
    @Column(name = "product")
    private String product;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "total")
    private Integer total;
    @Column(name = "createdby")
    private String createdby;

    // Getters and setters
    public Order() {
        super();
    }

    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }
}
