package reivosar.common.domain.model.message;

import reivosar.common.domain.model.message.Message;
import reivosar.common.domain.model.message.MessageId;

public interface MessageReposiory
{
	MessageId generateId();

	void save(Message message);
}
