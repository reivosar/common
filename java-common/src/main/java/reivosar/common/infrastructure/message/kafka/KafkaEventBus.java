package reivosar.common.infrastructure.message.kafka;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import reivosar.common.domain.model.event.Event;
import reivosar.common.event.EventBus;
import reivosar.common.event.EventResponse;
import reivosar.common.util.JsonUtil;
import reivosar.common.util.communication.response.ResponseStatus;
import reivosar.common.util.lang.TimeMeasurement;

@Component("KafkaEventBus")
public class KafkaEventBus implements EventBus {

    private final KafkaTemplate<String, String> template;

    @Autowired
    public KafkaEventBus(final KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @Override
    public EventResponse publish(final Event event) {
        Objects.requireNonNull(event, "event must not be null");
        final TimeMeasurement tm = TimeMeasurement.ready().start();
        try {
            this.template.send(event.getEventTopic(), JsonUtil.toJson(event));
            return new KafkaEventResponse(ResponseStatus.SUCCESS, tm);
        } catch (Exception cause) {
            return new KafkaEventResponse(ResponseStatus.CLIENT_ERROR, tm);
        } finally {
            tm.stop();
        }
    }
}
