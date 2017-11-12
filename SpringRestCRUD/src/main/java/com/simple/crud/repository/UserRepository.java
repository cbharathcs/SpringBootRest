package com.simple.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simple.crud.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
