package com.ex.prodse.repository;

import com.ex.prodse.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * fileName:ProductRepository
 * 작성날짜:2023-07-18
 * desc :
 **/
public interface ProductRepository extends CrudRepository<Product,Long> {
}
