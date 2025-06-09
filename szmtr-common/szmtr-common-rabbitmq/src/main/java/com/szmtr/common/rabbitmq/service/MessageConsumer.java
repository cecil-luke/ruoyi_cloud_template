package com.szmtr.common.rabbitmq.service;


import com.rabbitmq.client.Channel;
import com.szmtr.common.core.constant.Constants;
import com.szmtr.common.rabbitmq.config.RabbitMqInfo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MessageConsumer {
    @Autowired
    private RabbitMqInfo rabbitMqInfo;
    // 监听队列 A
    @RabbitListener(queues = "#{rabbitMqInfo.queueName}")
    public void receiveMessageFromA(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        try {
            System.out.println("【订阅者A】收到消息: " + message);
            channel.basicAck(tag, false);  // 确认消息
        } catch (Exception e) {
            channel.basicNack(tag, false, true);  // 拒绝消息并重新入队
        }
    }

}
