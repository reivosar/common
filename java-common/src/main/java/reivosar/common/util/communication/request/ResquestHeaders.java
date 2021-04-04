package reivosar.common.util.communication.request;

import java.util.List;

import reivosar.common.util.communication.header.Header;
import reivosar.common.util.communication.header.HeadersTemplate;

public class ResquestHeaders extends HeadersTemplate
{
    public ResquestHeaders() {
        super();
    }

    public ResquestHeaders(final List<Header> headers) {
        super(headers);
    }
}
