package reivosar.common.util.communication.header;

import java.util.Collection;
import java.util.Optional;
import java.util.OptionalLong;

import reivosar.common.util.collection.CollectionUtil;
import reivosar.common.util.lang.ArrayUtil;
import reivosar.common.util.lang.ObjectUtil;
import reivosar.common.util.lang.StringUtil;
import reivosar.common.util.model.ValueObject;

public abstract class HeaderValue extends ValueObject<HeaderValue> {
    final Collection<Object> values;

    @SafeVarargs
    public HeaderValue(Object... values) {
        this(ArrayUtil.asList(values));
    }

    public HeaderValue(Collection<Object> values) {
        this.values = values;
    }

    public Collection<Object> allValues() {
        return values;
    }

    public boolean hasValues() {
        return CollectionUtil.isNotEmpty(values);
    }

    public Optional<Object> firstValues() {
        return values.stream().findFirst();
    }

    public Optional<String> firstValueAsString() {
        return Optional.of(ObjectUtil.defaultIfNull(firstValues().get(), "").toString());
    }

    public OptionalLong firstValueAsLong() {
        final String str = firstValueAsString().get();
        if (!StringUtil.isNumeric(str))
            return OptionalLong.empty();
        return OptionalLong.of(Long.parseLong(str));
    }
}
