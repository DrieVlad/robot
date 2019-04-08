package com.example.demo;



import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GreatingController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(){


        return "hello";
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message change(Message message) {
        System.out.println(message);
        return null;
    }


}
