package com.hassware.service;

import com.hassware.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//Methods implementation
public interface OrderService {

    public List<Order> findAll();

    public Page<Order> findAll(Pageable pageable);

    public void save(Order order);

    public Order findOne(Integer idorder);

    public void delete(Integer idorder);
}
