package reivosar.common.domain.model.message;

public class MessageBodyChanged extends MessageEventTemplate
{
	private MessageId messageId;
	private MessageBody messageBody;

	public MessageBodyChanged() {
	}

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
