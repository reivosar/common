package reivosar.common.domain.model.event;

public interface EventReposiory
{
	EventId generateId();

	void save(Event event);
}
