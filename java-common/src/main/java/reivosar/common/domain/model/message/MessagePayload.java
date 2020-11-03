package reivosar.common.domain.model.message;

import reivosar.common.domain.model.ValueObject;

public class MessagePayload extends ValueObject<MessagePayload>
{
	final Object value;

	public MessagePayload(Object value) {
		this.value = value;
	}
}
