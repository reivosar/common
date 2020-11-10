package reivosar.common.domain.model.event;

public interface Event extends java.io.Serializable
{
	default EventId eventId() {
		return new EventId();
	}

	default EventVersion eventVersion() {
		return new EventVersion();
	}

	EventTopic eventTopic();

	default EventOccurredTime eventOccurredTime() {
		return new EventOccurredTime();
	}
}
