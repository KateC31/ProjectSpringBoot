package com.Inti.backend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_order;

    private String state;
    private Float total;
    private Date purchase_date;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private Users user;

    public Orders(Long id_order, String state, Float total, Date purchase_date, Users user) {
        this.id_order = id_order;
        this.state = state;
        this.total = total;
        this.purchase_date = purchase_date;
        this.user = user;
    }

    public Orders() {

    }

    public Long getId_order() { return id_order; }
    public void setId_order(Long id_order) { this.id_order = id_order; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public Float getTotal() { return total; }
    public void setTotal(Float total) { this.total = total; }

    public Date getPurchase_date() { return purchase_date; }
    public void setPurchase_date(Date purchase_date) { this.purchase_date = purchase_date; }

    public Users getUser() { return user; } // 🔥 Devuelve el objeto completo
    public void setUser(Users user) { this.user = user; } // 🔥 Se guarda la relación
}
