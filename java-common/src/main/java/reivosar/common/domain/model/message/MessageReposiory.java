package reivosar.common.domain.model.message;

public interface MessageReposiory
{
	MessageId generateId();

	void save(Message message);
}
