package reivosar.common.domain.model.message;

import reivosar.common.domain.model.EventableEnity;

public class Message extends EventableEnity<MessageId, Message>
{
	private MessageId messageId;
	private MessageMetaData messageMetaData;
	private MessageBody messageBody;

	public Message(
		MessageId messageId,
		MessageBody messageBody)
	{
		this(messageId, new MessageMetaData(), messageBody);
	}

	public Message(
		MessageId messageId,
		MessageMetaData messageMetaData,
		MessageBody messageBody)
	{
		setMessageId       (messageId);
		setMessageMetaData (messageMetaData);
		setMessageBody     (messageBody);
	}

	public Message createMessage() {
		apply(
			new MessageCreated (
				this.messageId,
				this.messageMetaData,
				this.messageBody
			)
		);
		return this;
	}

	public Message changeMessageBody(MessageBody messageBody) {
		setMessageBody(messageBody);
		apply(new MessageBodyChanged(messageId, messageBody));
		return this;
	}

	@Override
	public MessageId publicId() {
		return messageId;
	}

	private void setMessageId(MessageId messageId) {
		this.messageId = messageId;
	}

	private void setMessageMetaData(MessageMetaData messageMetaData) {
		this.messageMetaData = messageMetaData;
	}

	private void setMessageBody(MessageBody messageBody) {
		this.messageBody = messageBody;
	}
}
