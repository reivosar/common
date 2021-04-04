package reivosar.common.util.communication.header;

public interface Headers extends Iterable<Header>
{
    Headers add(Header header);

    Headers add(HeaderKey key, HeaderValue value);

    Headers remove(HeaderKey key) ;

    Header lastHeader(HeaderKey key);

    Iterable<Header> headers(HeaderKey key);

    Header[] toArray();
}
