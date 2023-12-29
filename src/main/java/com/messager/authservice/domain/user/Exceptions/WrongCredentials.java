package com.messager.authservice.domain.user.Exceptions;

public class WrongCredentials extends Exception {
  public WrongCredentials() {
    super("Login failed");
  }
}
