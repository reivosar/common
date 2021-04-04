package reivosar.common.event;

import reivosar.common.domain.model.event.Event;

public interface EventBus
{
    public EventResponse publish(Event eventRequest);
}
