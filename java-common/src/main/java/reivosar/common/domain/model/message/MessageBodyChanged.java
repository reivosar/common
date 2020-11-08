package reivosar.common.domain.model.message;

import reivosar.common.domain.model.event.Event;

public class MessageBodyChanged implements Event
{
	private final MessageId messageId;
	private final MessageBody messageBody;

	public MessageBodyChanged(MessageId messageId, MessageBody messageBody) {
		this.messageId   = messageId;
		this.messageBody = messageBody;
	}

	public MessageId getMessageId() {
		return messageId;
	}

	public MessageBody getMessageBody() {
		return messageBody;
	}
}
