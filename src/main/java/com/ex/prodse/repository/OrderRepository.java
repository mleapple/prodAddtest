package com.ex.prodse.repository;

import com.ex.prodse.entity.Order;
import com.ex.prodse.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * fileName:OrderRepository
 * 작성날짜:2023-07-18
 * desc :
 **/
public interface OrderRepository extends CrudRepository<Order,Long> {
}