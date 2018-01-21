package com.code4life.ecommerce.repositories;

import com.code4life.ecommerce.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
