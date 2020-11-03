package reivosar.common.domain.model.event;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class EventableAggregate
{
	private final Collection<Event> events;

	public EventableAggregate() {
		this.events = Collections.emptyList();
	}

	protected void eventOccurred(Event...domainEvents) {
		this.events.addAll(Arrays.asList(domainEvents));
	}

	public Collection<Event> allEvents() {
		return Collections.unmodifiableCollection(events);
	}

	public Collection<Event> allEvents(EventVersion eventVersion) {
		return allEvents().stream()
			.filter  (event -> event.eventVersion().equals(eventVersion))
			.collect (Collectors.toUnmodifiableList());
	}
}
