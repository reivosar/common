package reivosar.common.domain.model.message;

import reivosar.common.domain.model.event.Event;
import reivosar.common.domain.model.event.EventTopic;

abstract class MessageEventTemplate implements Event
{
	@Override
	public EventTopic eventTopic() {
		return new EventTopic("MessageEventTopic");
	}
}
