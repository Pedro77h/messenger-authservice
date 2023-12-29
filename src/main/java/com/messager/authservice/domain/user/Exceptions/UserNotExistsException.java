package com.messager.authservice.domain.user.Exceptions;

public class UserNotExistsException extends Exception {
  public UserNotExistsException(String username) {
    super("the user" + username + " already exists");
  }
}
