package com.messager.authservice.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.messager.authservice.domain.user.User;
import com.messager.authservice.domain.user.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/v1/auth")
public class UserConctroller {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<Void> register(@RequestBody User user, HttpServletResponse response) {
    try {
      final String token = this.userService.registerUser(user);

      Cookie authCookie = new Cookie("Authorization", token);
      authCookie.setHttpOnly(true);
      authCookie.setMaxAge(7 * 24 * 60 * 60);

      response.addCookie(authCookie);

      return new ResponseEntity<>(null, HttpStatus.CREATED);
    } catch (Exception e) {
        System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
  }

  @PostMapping("/login")
  public ResponseEntity<Void> login(@RequestBody User user, HttpServletResponse response) {
    try {
      final String token = this.userService.login(user);

      Cookie authCookie = new Cookie("Authorization", token);
      authCookie.setHttpOnly(true);
      authCookie.setMaxAge(7 * 24 * 60 * 60);

      response.addCookie(authCookie);

      return new ResponseEntity<>(null, HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
  }
}
