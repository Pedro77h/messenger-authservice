package com.example.pedro.authservice.infra.User;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UserController {

  @RabbitListener(queues = "AUTH_QUEUE" )
  public void receive(@Payload String body) {
    System.out.println("Message " + body);
  }

}
