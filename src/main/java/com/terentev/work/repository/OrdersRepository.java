package com.terentev.work.repository;

import com.terentev.work.entity.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
}
