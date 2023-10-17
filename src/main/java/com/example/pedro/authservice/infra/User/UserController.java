package com.example.pedro.authservice.infra.User;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.pedro.authservice.core.Utils.Messages;

@Component
public class UserController {

  @RabbitListener(queues = { Messages.POST_USER })
  public void receive(@Payload String body) {
    System.out.println("Message " + body);
  }
}
