package com.fecd.kafkaproducer.kafka.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Map;

@Configuration
public class KafkaTopic {
    private Map<String, String> configs() {
        return Map.of(
                TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE,
                TopicConfig.RETENTION_MS_CONFIG, String.valueOf(1000 * 60 * 60 * 24),
                TopicConfig.SEGMENT_MS_CONFIG, String.valueOf(1000 * 60 * 60 * 24),
                TopicConfig.RETENTION_BYTES_CONFIG, String.valueOf(1000 * 1000 * 1000)
        );
    }

    @Bean
    public NewTopic generateTopic() {
        return TopicBuilder.name(TopicNames.CUSTOMERS.name())
                .partitions(2)
                .replicas(1)
                .compact()
                .configs(this.configs())
                .build();
    }
}
