package reivosar.common.domain.model.message;

import reivosar.common.domain.model.Identity;

public class MessageId extends Identity<MessageId>
{
	final String value;

	public MessageId() {
		this(genereteNativeIdByUUID());
	}

	public MessageId(String value) {
		this.value = value;
	}
}
