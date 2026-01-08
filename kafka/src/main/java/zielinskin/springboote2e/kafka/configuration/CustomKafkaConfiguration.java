package zielinskin.springboote2e.kafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableKafka
public class CustomKafkaConfiguration {
    public static final String TOPIC_NAME = "thing1";

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name(TOPIC_NAME)
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public GroupedOpenApi kafkaDocket() {
        return GroupedOpenApi.builder()
                .group("Kafka")
                .pathsToMatch("/kafka/**")
                .build();
    }
}
