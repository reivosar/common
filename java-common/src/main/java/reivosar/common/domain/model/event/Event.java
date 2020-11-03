package reivosar.common.domain.model.event;

public interface Event
{
	default EventId eventId() {
		return new EventId();
	}

	EventVersion eventVersion();

	default EventOccurredTime eventOccurredTime() {
		return new EventOccurredTime();
	}
}
