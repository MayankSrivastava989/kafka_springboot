package com.alibou.kafka.consumer;

import com.alibou.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {

    // @KafkaListener(topics = "alibou", groupId = "myGroup")
    public void consumeMsg(String msg) {
        log.info(format("Consuming the message from alibou Topic:: %s", msg));
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "mytopic",partitions = {"0"}),groupId = "my-consumer")
//    @KafkaListener(topics = "mytopic", groupId = "my-consumer")
    public void consumeStudentJson1(Student student){
        log.info(format("Consuming the message from mytopic partition 0 Topic:: %s", student.toString()));
    }
    @KafkaListener(topicPartitions = @TopicPartition(topic = "mytopic",partitions = {"1"}),groupId = "myGroup")
//    @KafkaListener(topics = "mytopic", groupId = "my-consumer")
    public void consumeStudentJson2(Student student){
        log.info(format("Consuming the message from mytopic partition 1 Topic:: %s", student.toString()));
    }
}
