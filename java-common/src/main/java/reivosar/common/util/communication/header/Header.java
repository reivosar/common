package reivosar.common.util.communication.header;

import reivosar.common.util.model.ValueObject;

public class Header extends ValueObject<Header>
{
    final HeaderKey key;
    final HeaderValue value;

    public Header(HeaderKey key, HeaderValue value) {
        this.key   = key;
        this.value = value;
    }

    public boolean equalsKey(HeaderKey key) {
        return this.key.equals(key);
    }
}
