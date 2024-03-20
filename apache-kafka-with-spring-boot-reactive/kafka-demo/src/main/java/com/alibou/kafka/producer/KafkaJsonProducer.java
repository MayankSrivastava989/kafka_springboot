package com.alibou.kafka.producer;

import com.alibou.kafka.payload.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Student> kafkaTemplate;
    private static int partition=0;

    public void sendMessage(Student student){
        kafkaTemplate.send("mytopic",partition,student.getId(),student);
        if(partition<2)
            partition++;
        else
            partition=0;
    }
}
