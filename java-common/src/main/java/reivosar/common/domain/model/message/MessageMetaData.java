package reivosar.common.domain.model.message;

import java.util.Collections;
import java.util.Map;

import reivosar.common.domain.model.ValueObject;

public class MessageMetaData extends ValueObject<MessageMetaData>
{
	final Map<String, Object> values;

	public MessageMetaData() {
		this.values = Collections.emptyMap();
	}

	public MessageMetaData set(String key, Object value) {
		this.values.put(key, value);
		return this;
	}
}
