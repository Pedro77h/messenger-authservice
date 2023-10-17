package com.example.pedro.authservice.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pedro.authservice.domain.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
