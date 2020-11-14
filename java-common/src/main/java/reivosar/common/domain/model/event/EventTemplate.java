package reivosar.common.domain.model.event;

import reivosar.common.domain.model.Model;

public abstract class EventTemplate extends Model implements Event
{
	private final EventId eventId;
	private final EventVersion eventVersion;
	private final EventTopic eventTopic;
	private final EventOccurredTime eventOccurredTime;

	public EventTemplate(EventTopic eventTopic) {
		this(new EventId(), new EventVersion(), eventTopic, new EventOccurredTime());
	}

	public EventTemplate(
		EventId eventId,
		EventVersion eventVersion,
		EventTopic eventTopic,
		EventOccurredTime eventOccurredTime)
	{
		this.eventId           = eventId;
		this.eventVersion      = eventVersion;
		this.eventTopic        = eventTopic;
		this.eventOccurredTime = eventOccurredTime;
	}


	@Override
	public EventId getEventId() {
		return eventId;
	}

	@Override
	public EventVersion getEventVersion() {
		return eventVersion;
	}

	@Override
	public EventTopic getEventTopic() {
		return eventTopic;
	}

	@Override
	public EventOccurredTime getEventOccurredTime() {
		return eventOccurredTime;
	}
}
