package com.example.pedro.authservice.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pedro.authservice.domain.entities.User;
import com.example.pedro.authservice.domain.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> getUsers() {
    return (List<User>) this.userRepository.findAll();
  }

  public User create(User user) {
    return this.userRepository.save(user);
  }

}
