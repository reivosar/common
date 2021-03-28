package reivosar.common.domain.model;

import java.util.Collection;

import reivosar.common.domain.model.event.Event;
import reivosar.common.domain.model.event.EventStore;
import reivosar.common.domain.model.event.EventVersion;

@SuppressWarnings("unchecked")
public abstract class EventableEntity<ID extends Identity<ID>, ENTITY> extends Entity<ID, ENTITY>
{
	private final EventStore store;

	public EventableEntity() {
		this.store = new EventStore();
	}

	protected <R extends EventableEntity<ID, ENTITY>> R apply(Event...domainEvents) {
		this.store.eventOccurred(domainEvents);
		return (R) this;
	}

	public Collection<Event> allEvents() {
		return store.allEvents();
	}

	public Collection<Event> allEvents(EventVersion eventVersion) {
		return store.allEvents(eventVersion);
	}

	public <R extends EventableEntity<ID, ENTITY>> R clear() {
        this.store.clear();
        return (R) this;
    }

    public boolean hasEvents() {
        return store.hasEvents();
    }
}
