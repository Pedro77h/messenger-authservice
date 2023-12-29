package com.messager.authservice.config;

import java.util.Map;

import com.messager.authservice.domain.user.User;

public interface JwtGeneratorInterface {
  public String generateToken(User user);
}
