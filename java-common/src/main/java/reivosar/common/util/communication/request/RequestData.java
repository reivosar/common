package reivosar.common.util.communication.request;

import java.util.List;

import reivosar.common.util.communication.data.DataTemplate;
import reivosar.common.util.communication.data.Payload;

public class RequestData extends DataTemplate {

    public RequestData() {
        super();
    }

    public RequestData(final List<Payload> payloads) {
        super(payloads);
    }
}
