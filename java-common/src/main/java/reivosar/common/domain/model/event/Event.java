package reivosar.common.domain.model.event;

public interface Event extends java.io.Serializable
{
	EventId getEventId();

	EventVersion getEventVersion();

	EventTopic getEventTopic();

	EventOccurredTime getEventOccurredTime();
}