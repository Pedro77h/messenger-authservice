package com.messager.authservice.config;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.messager.authservice.domain.user.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGeneratorImpl implements JwtGeneratorInterface {
  @Value("${jwt.secret}")
  private String secret;

  @Override
  public String generateToken(User user) {
    String JwtToken = Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date())
        .signWith(SignatureAlgorithm.HS256, this.secret).compact();

    return JwtToken;
  }

}
