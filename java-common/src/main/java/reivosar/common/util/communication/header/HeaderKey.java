package reivosar.common.util.communication.header;

import reivosar.common.util.model.ValueObject;

public class HeaderKey extends ValueObject<HeaderKey>
{
    final String value;

    public HeaderKey(String value) {
        this.value = value;
    }
}
