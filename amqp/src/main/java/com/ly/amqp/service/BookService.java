package com.ly.amqp.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Map map) {
        System.out.println(map);
    }

    @RabbitListener(queues = "atguigu.emps")
    public void receive2(Message map) {
        System.out.println(map.getBody());
        System.out.println(map.getMessageProperties());
    }
}
