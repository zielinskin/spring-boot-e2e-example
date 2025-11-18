package zielinskin.springboote2e.kafka.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zielinskin.springboote2e.kafka.logic.KafkaReceiver;
import zielinskin.springboote2e.kafka.logic.KafkaSender;

import java.util.List;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final KafkaSender kafkaSender;

    public KafkaController(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @GetMapping("/send/{messageCount}")
    public void sendMessages(@PathVariable("messageCount") Integer messageCount) {
        kafkaSender.sendValues(messageCount);
    }


    @GetMapping("/messageOrder")
    public List<String> getMessageOrder() {
        return KafkaReceiver.getMessageOrder();
    }
}
