package reivosar.common.domain.model.message;

import java.util.Collections;
import java.util.Map;

import reivosar.common.domain.model.ValueObject;

public class MessageMetaData extends ValueObject<MessageMetaData>
{
	final Map<String, Object> values;

	public MessageMetaData() {
		this(Collections.emptyMap());
	}

    public MessageMetaData(Map<String, Object> values) {
        this.values = values;
    }

	public MessageMetaData set(String key, Object value) {
		this.values.put(key, value);
		return this;
	}
}
