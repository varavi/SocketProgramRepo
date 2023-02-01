package com.rkv.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import java.util.Base64;
import java.util.Random;

@Controller
public class TempratatureNotificationController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // to handle /app/application
    @MessageMapping("/application")
    @SendTo("/all/messages")
    public Message<String> sendNotification(final Message<String> message) throws Exception {
        System.out.println("message ::" + message.getPayload());
        return message;
    }

    //to handle /app/private
    @MessageMapping("/private")
    public void sendToSpecificUser(@Payload com.rkv.notification.model.Message message) throws InterruptedException {
        int min=1,max=60;
        String name=message.getText();
        while(true){
         //dummy socket data generation
            Random random = new Random();
            double randTemp = random.nextInt((max - min) + 1) + min;
        // dummy user condition after getting the logged in user
        // receive the temperature
            double minTemp=20;
            double maxTemp=45;

            //input dummy from socket live data

        if(randTemp<=minTemp && maxTemp>=randTemp) {
            message.setText( name+" ! Today's temperature "+randTemp);
            simpMessagingTemplate.convertAndSendToUser(message.getTo(), "/specific", message);
            Thread.sleep(2000);

        }
            System.out.println("Notified based on condition to user :: temp :: "+randTemp);
        }


    }
}
