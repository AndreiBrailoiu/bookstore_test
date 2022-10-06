package com.example.Bookstore.model;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long>{
	UserEntity findByUsername(String username);
}
