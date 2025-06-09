package com.szmtr.common.rabbitmq.config;


import com.szmtr.common.core.constant.Constants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Autowired
    private RabbitMqInfo rabbitMqInfo;

    // 1. 定义 Fanout Exchange
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(rabbitMqInfo.switchName, true, false);
    }

    // 2. 定义两个队列（模拟两个订阅者）
    @Bean
    public Queue queueA() {
        return new Queue(rabbitMqInfo.queueName, true, false, false);
    }


    // 3. 将队列绑定到 Fanout Exchange
    @Bean
    public Binding bindingA(FanoutExchange fanoutExchange, Queue queueA) {
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    // 4. 配置 JSON 消息转换器（可选）
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


}
