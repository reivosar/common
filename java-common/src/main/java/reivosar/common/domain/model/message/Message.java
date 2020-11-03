package reivosar.common.domain.model.message;

import reivosar.common.domain.model.Entity;

public class Message extends Entity<MessageId, Message>
{
	final MessageId messageId;
	final MessageChannel messageChannel;
	final MessageMetaData messageMetaData;
	final MessageBody messageBody;

	public Message(
		MessageId messageId,
		MessageChannel messageChannel,
		MessageBody messageBody)
	{
		this(messageId, messageChannel, new MessageMetaData(), messageBody);
	}

	public Message(
		MessageId messageId,
		MessageChannel messageChannel,
		MessageMetaData messageMetaData,
		MessageBody messageBody)
	{
		this.messageId       = messageId;
		this.messageChannel  = messageChannel;
		this.messageMetaData = messageMetaData;
		this.messageBody     = messageBody;
	}

	@Override
	public MessageId publicId() {
		return messageId;
	}
}
