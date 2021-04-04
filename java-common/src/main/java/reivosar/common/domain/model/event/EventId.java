package reivosar.common.domain.model.event;

import reivosar.common.util.model.Identity;

public class EventId extends Identity<EventId>
{
	final String value;

	public EventId() {
		this.value = genereteNativeIdByUUID();
	}
}
