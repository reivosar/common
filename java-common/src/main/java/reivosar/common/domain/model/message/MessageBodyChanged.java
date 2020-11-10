package reivosar.common.domain.model.message;

import reivosar.common.util.JsonUtils;

public class MessageBodyChanged extends MessageEventTemplate
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

	public static void main(String[] args) {
		System.out.println(JsonUtils.toJson(new MessageBodyChanged(new MessageId(), MessageBody.of("test"))));
	}
}
