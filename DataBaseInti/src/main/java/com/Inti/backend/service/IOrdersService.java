package com.Inti.backend.service;
import com.Inti.backend.model.Orders;
import java.util.List;

public interface IOrdersService {

    public List<Orders> getOrders();

    public void saveOrder(Orders order);

    public void deleteOrder(Long id);

    public Orders findOrder(Long id);
}
