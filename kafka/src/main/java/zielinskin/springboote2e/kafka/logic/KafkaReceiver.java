package zielinskin.springboote2e.kafka.logic;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static zielinskin.springboote2e.kafka.configuration.CustomKafkaConfiguration.TOPIC_NAME;

@Service
public class KafkaReceiver {
    private static final List<String> MESSAGE_ORDER = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(KafkaReceiver.class);

    @KafkaListener(id = "group1",
            topics = TOPIC_NAME,
            autoStartup = "true",
            concurrency = "10")
    public void listen(ConsumerRecord<String, String> record) {
        try {
            Thread.sleep((int) (Math.random() * 100));
        } catch (Exception e) {
            logger.error("Error while sleeping", e);
        }

        MESSAGE_ORDER.add(record.value());
    }

    public static List<String> getMessageOrder() {
        return new ArrayList<>(MESSAGE_ORDER);
    }
}
