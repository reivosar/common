package reivosar.common.util.communication.header;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

import reivosar.common.util.collection.IteratorUtil;
import reivosar.common.util.model.ValueObject;

public abstract class HeadersTemplate extends ValueObject<HeadersTemplate> implements Headers
{
    private static final Header[] EMPTY_HEADERS = new Header[0];

    private final List<Header> headers;

    public HeadersTemplate() {
        this(new ArrayList<Header>());
    }

    public HeadersTemplate(final List<Header> headers) {
        if (headers == null) {
            this.headers = new ArrayList<>();
        } else {
            this.headers = new ArrayList<>(headers);
        }
    }

    @Override
    public final Iterator<Header> iterator() {
        return this.headers.iterator();
    }

    @Override
    public int countHeader() {
        return headers.size();
    }

    @Override
    public boolean hasHeader() {
        return countHeader() > 0;
    }

    @Override
    public final Headers add(final Header header) {
        checkHeader(header);
        this.headers.add(header);
        return this;
    }

    @Override
    public final Headers add(final HeaderKey key, final HeaderValue value) {
        checkKey(key);
        checkValue(value);
        return add(new Header(key, value));
    }

    @Override
    public final Headers remove(final HeaderKey key) {
        checkKey(key);
        final Iterator<Header> itr = headers(key).iterator();
        while (itr.hasNext())
            itr.remove();
        return this;
    }

    @Override
    public final Optional<Header> lastHeader(final HeaderKey key) {
        checkKey(key);
        for (int i = headers.size() - 1; i >= 0; i--) {
            Header header = headers.get(i);
            if (header.key.equals(key)) {
                return Optional.of(header);
            }
        }
        return Optional.empty();
    }

    @Override
    public final Iterable<Header> headers(final HeaderKey key) {
        checkKey(key);
        return () ->
            IteratorUtil.filteredIterator(headers.iterator(), new Predicate<Header>() {
                @Override
                public boolean test(Header t) {
                    return t.equalsKey(key);
                }
            });
    }

    @Override
    public final Header[] toArray() {
        return headers.isEmpty() ? EMPTY_HEADERS : headers.toArray(new Header[headers.size()]);
    }

    private void checkHeader(Header header) {
        Objects.requireNonNull(header, "header cannot be null.");
    }

    private void checkKey(HeaderKey key) {
        Objects.requireNonNull(key, "key cannot be null.");
    }

    private void checkValue(HeaderValue value) {
        Objects.requireNonNull(value, "value cannot be null.");
    }
}
