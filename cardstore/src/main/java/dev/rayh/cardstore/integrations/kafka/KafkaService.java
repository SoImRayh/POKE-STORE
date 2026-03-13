package dev.rayh.cardstore.integrations.kafka;

public interface KafkaService<T> {
    void postMessage(String Topic, T t);
}
