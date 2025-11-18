package zielinskin.springboote2e.kafka.logic;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static zielinskin.springboote2e.kafka.configuration.CustomKafkaConfiguration.TOPIC_NAME;

@Service
public class KafkaSender {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendValues(Integer numValues) {
        for(int i = 0; i < numValues; i++) {
            kafkaTemplate.send(TOPIC_NAME, String.valueOf(i));
        }
        kafkaTemplate.flush();
    }
}
