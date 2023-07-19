package com.ex.prodse.repository;

import com.ex.prodse.entity.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 * fileName:PayRepository
 * 작성날짜:2023-07-19
 * desc :
 **/
public interface PayRepository extends CrudRepository<Payment,Long> {
}
