package com.kafka.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfiguration {

    @Bean
    public NewTopic testTopic(){
        return TopicBuilder.name("testTopic")
                .build();
    }

    @Bean
    public NewTopic testJsonTopic(){
        return TopicBuilder.name("testJsonTopic")
                .build();
    }
}
