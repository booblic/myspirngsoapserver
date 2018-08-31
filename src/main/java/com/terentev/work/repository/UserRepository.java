package com.terentev.work.repository;

import org.springframework.data.repository.CrudRepository;

import com.terentev.work.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
