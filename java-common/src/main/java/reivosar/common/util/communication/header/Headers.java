package reivosar.common.util.communication.header;

import java.util.Optional;

public interface Headers extends Iterable<Header>
{
    Headers add(Header header);

    Headers add(HeaderKey key, HeaderValue value);

    Headers remove(HeaderKey key);

    boolean hasHeader();

    int countHeader();

    Optional<Header> lastHeader(HeaderKey key);

    Iterable<Header> headers(HeaderKey key);

    Header[] toArray();
}
