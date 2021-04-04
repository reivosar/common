package reivosar.common.domain.model.event;

import reivosar.common.util.model.ValueObject;

public class EventVersion extends ValueObject<EventVersion>
{
	final Integer value;

	public EventVersion() {
		this(1);
	}

	public EventVersion(int value) {
		this.value = value;
	}
}
