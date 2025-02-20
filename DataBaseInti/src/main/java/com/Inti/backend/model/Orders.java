package com.Inti.backend.model;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id_order;
    private String state;
    private Float total;
    private Date  purchase_date;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id_categories", nullable = false)
    private Long user_id;

    public Orders(Long id_order, String state, Float total, Date purchase_date, Long user_id) {
        this.id_order = id_order;
        this.state = state;
        this.total = total;
        this.purchase_date = purchase_date;
        this.user_id = user_id;
    }
    public Long getId_order() {
        return id_order;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }





}
