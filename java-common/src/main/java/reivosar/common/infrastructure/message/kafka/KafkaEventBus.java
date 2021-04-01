package reivosar.common.infrastructure.message.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import reivosar.common.domain.model.event.Event;
import reivosar.common.event.EventBus;
import reivosar.common.event.EventPublishException;
import reivosar.common.util.JsonUtil;

@Component("KafkaEventBus")
public class KafkaEventBus implements EventBus {

    private final KafkaTemplate<String, String> template;

    @Autowired
    public KafkaEventBus(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @Override
    public Object publish(Event event) {
        try {
            return this.template.send(event.getEventTopic(), JsonUtil.toJson(event));
        } catch (Exception cause) {
            throw new EventPublishException(cause);
        }
    }
}
