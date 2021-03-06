package reivosar.common.domain.model.event;

import reivosar.common.domain.model.time.DateTime;
import reivosar.common.util.model.ValueObject;

public class EventOccurredTime extends ValueObject<EventOccurredTime>
{
	final DateTime value;

	public EventOccurredTime() {
		this(DateTime.now());
	}

	public EventOccurredTime(DateTime value) {
		this.value = value;
	}
}
