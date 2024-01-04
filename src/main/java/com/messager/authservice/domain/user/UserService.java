package com.messager.authservice.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.messager.authservice.config.JwtGeneratorInterface;
import com.messager.authservice.domain.user.Exceptions.UserExistsException;
import com.messager.authservice.domain.user.Exceptions.UserNotExistsException;
import com.messager.authservice.domain.user.Exceptions.WrongCredentials;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  private JwtGeneratorInterface jwtGenerator;

  public String registerUser(User user) throws UserExistsException {
    if (this.userRepository.findByUsername(user.getUsername()) != null) {
      throw new UserExistsException(user.getUsername());
    }

    String encondedPassword = this.passwordEncoder.encode(user.getPassword());
    user.setPassword(encondedPassword);

    this.userRepository.save(user);

    return this.jwtGenerator.generateToken(user);
  }

  public String login(User user) throws WrongCredentials, UserNotExistsException {
    User dbUser = this.userRepository.findByUsername(user.getUsername());

    if (dbUser == null) {
      throw new UserNotExistsException(user.getUsername());
    }

    Boolean decryptedPassowrd = this.passwordEncoder.matches(user.getPassword(), dbUser.getPassword());

    if (decryptedPassowrd == false)
      throw new WrongCredentials();

    return this.jwtGenerator.generateToken(user);
  }
}
