package reivosar.common.util.communication.response;

import java.util.List;

import reivosar.common.util.communication.header.Header;
import reivosar.common.util.communication.header.HeadersTemplate;

public class ResponseHeaders extends HeadersTemplate
{
    public ResponseHeaders() {
        super();
    }

    public ResponseHeaders(final List<Header> headers) {
        super(headers);
    }
}
