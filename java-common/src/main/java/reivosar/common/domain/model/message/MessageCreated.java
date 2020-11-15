package reivosar.common.domain.model.message;

import java.util.Map;

public class MessageCreated extends MessageEventTemplate
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

	public String getMessageId() {
		return messageId.value;
	}

	public Map<String, Object> getMessageMetaData() {
		return messageMetaData.values;
	}

	public Object getMessageBody() {
		return messageBody.messagePayload.value;
	}
}
