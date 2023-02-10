package com.hassware.service;

import com.hassware.domain.Product;
import com.hassware.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true) // Annotation for optimizing memory usage
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true) // Annotation for optimizing memory usage
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    @Transactional(readOnly = true)
    public Product findOne(Integer idproduct) {
        return productRepository.findById(idproduct).orElse(null);
    }

    @Override
    public void delete(Integer idproduct) {
        productRepository.deleteById(idproduct);
    }
}
