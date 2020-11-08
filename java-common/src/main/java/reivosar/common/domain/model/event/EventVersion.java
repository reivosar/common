package reivosar.common.domain.model.event;

import reivosar.common.domain.model.ValueObject;

public class EventVersion extends ValueObject<EventVersion>
{
	final int value;

	public EventVersion(int value) {
		this.value = value;
	}
}
