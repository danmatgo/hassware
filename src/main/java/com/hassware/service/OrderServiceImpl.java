package com.hassware.service;

import com.hassware.domain.Order;
import com.hassware.domain.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional(readOnly = true) // Annotation for optimizing memory usage
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true) // Annotation for optimizing memory usage
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Order order) {
        orderRepository.save(order);

    }

    @Override
    @Transactional(readOnly = true)
    public Order findOne(Integer idorder) {
        return orderRepository.findById(idorder).orElse(null);
    }

    @Override
    public void delete(Integer idorder) {
        orderRepository.deleteById(idorder);
    }
}
