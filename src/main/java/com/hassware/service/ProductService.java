package com.hassware.service;

import com.hassware.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//Methods implementation
public interface ProductService {

    public List<Product> findAll();

    public Page<Product> findAll(Pageable pageable);

    public void save(Product product);

    public Product findOne(Integer idproduct);

    public void delete(Integer idproduct);
}
