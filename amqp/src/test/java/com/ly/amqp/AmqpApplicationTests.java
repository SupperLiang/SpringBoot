package com.ly.amqp;

import com.ly.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmqpApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 单播（点对点）
     */
    @Test
    public void contextLoads() {
        // Message需要自己构造一个；定义消息体内容和消息头
        // rabbitTemplate.send(exchage,routeKey,Message);

        // object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
        // rabbitTemplate.convertAndSend(exchage,routeKey,object);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "第一个小消息");
        map.put("data", Arrays.asList("hellowrd", 123, true));
        //对象默认被序列化后发送
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", map);
    }

    /**
     * 接受（点对点）
     */
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    @Test
    public void sendMsg() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "第一个小消息");
        map.put("data", Arrays.asList("hellowrd", 123, true));
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("中国"));
    }

    @Test
    public void createExchane() {

        // amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        // amqpAdmin.declareQueue(new Queue("qmqpadmin.queue"));

        amqpAdmin.declareBinding(new Binding("qmqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.exchange", "qmqpadmin.haha", null));
    }
}
