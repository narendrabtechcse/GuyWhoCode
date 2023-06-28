package Java.java7less.interviewasked;


import java.util.Collections;
import java.util.Properties;

public class PushConsumerExample {
    public static <KafkaConsumer, ConsumerRecords, ConsumerRecord> void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "my-consumer-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        //KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        //consumer.subscribe(Collections.singletonList("my-topic"));
        //try {
        //while (true) {
        //      ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
        //    for (ConsumerRecord<String, String> record : records) { // Process each received message System.out.println("Received message: " + record.value()); } } } finally { consumer.close(); } } }
    }
    }