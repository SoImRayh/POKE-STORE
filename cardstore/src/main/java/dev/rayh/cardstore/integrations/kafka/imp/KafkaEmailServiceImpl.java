package dev.rayh.cardstore.integrations.kafka.imp;

import dev.rayh.cardstore.integrations.kafka.KafkaService;
import dev.rayh.contracts.EmailEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaEmailServiceImpl implements KafkaService<EmailEvent> {

    private final KafkaTemplate<String, EmailEvent> template;

    @Override
    public void postMessage(String topic, EmailEvent event) {

        template.send(topic, event);
    }
}
