package reivosar.common.domain.model.message;

import reivosar.common.domain.model.event.Event;

public class MessageCreated implements Event
{
	private final MessageId messageId;
	private final MessageMetaData messageMetaData;
	private final MessageBody messageBody;

	public MessageCreated(
		MessageId messageId,
		MessageMetaData messageMetaData,
		MessageBody messageBody)
	{
		this.messageId       = messageId;
		this.messageMetaData = messageMetaData;
		this.messageBody     = messageBody;
	}

	public MessageId getMessageId() {
		return messageId;
	}

	public MessageMetaData getMessageMetaData() {
		return messageMetaData;
	}

	public MessageBody getMessageBody() {
		return messageBody;
	}
}
