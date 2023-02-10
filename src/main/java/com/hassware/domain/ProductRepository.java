package com.hassware.domain;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
}
