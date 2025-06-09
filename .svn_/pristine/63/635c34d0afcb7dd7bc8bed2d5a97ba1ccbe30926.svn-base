package com.szmtr.common.rabbitmq.service;


import com.szmtr.common.core.constant.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class MessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // 发送消息到 Fanout Exchange
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(Constants.RABBITMQ_FANOUT_EXCHANGE, "", message);
        // 参数说明：
        // exchange: "fanout.exchange"
        // routingKey: 空字符串（Fanout 模式忽略 routingKey）
        // message: 消息内容
    }
}
