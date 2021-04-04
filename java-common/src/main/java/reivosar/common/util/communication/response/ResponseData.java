package reivosar.common.util.communication.response;

import java.util.List;

import reivosar.common.util.communication.data.DataTemplate;
import reivosar.common.util.communication.data.Payload;

public class ResponseData extends DataTemplate
{
    public ResponseData() {
        super();
    }

    public ResponseData(final List<Payload> headers) {
        super(headers);
    }
}
