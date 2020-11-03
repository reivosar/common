package reivosar.common.domain.model.message;

import reivosar.common.domain.model.ValueObject;

public class MessageChannel extends ValueObject<MessageChannel> {

	final String value;

	public MessageChannel(String value) {
		this.value = value;
	}
}
