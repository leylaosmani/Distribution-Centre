package com.example.distributioncentre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.distributioncentre.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
