package reivosar.common.domain.model.event;

import java.time.LocalDateTime;

public interface Event extends java.io.Serializable
{
	String getEventId();

	int getEventVersion();

	String getEventTopic();

	LocalDateTime getEventOccurredTime();
}