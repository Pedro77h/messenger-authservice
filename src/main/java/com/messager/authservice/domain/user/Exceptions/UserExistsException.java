package com.messager.authservice.domain.user.Exceptions;

public class UserExistsException extends Exception {
  public UserExistsException(String username) {
    super("The user " + username + "exists");
  }

}