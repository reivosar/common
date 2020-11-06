package reivosar.common.domain.model.message;

import reivosar.common.domain.model.ValueObject;

public class MessageBody extends ValueObject<MessageBody> {

	final MessageBodyType messageBodyType;
	final MessagePayload messagePayload;

	public MessageBody(
		MessageBodyType messageBodyType,
		MessagePayload messagePayload)
	{
		this.messageBodyType = messageBodyType;
		this.messagePayload  = messagePayload;
	}
}
