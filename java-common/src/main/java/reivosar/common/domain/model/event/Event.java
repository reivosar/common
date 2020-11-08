package reivosar.common.domain.model.event;

public interface Event
{
	default EventId eventId() {
		return new EventId();
	}

	default EventVersion eventVersion() {
		return new EventVersion();
	}

	default EventOccurredTime eventOccurredTime() {
		return new EventOccurredTime();
	}
}
