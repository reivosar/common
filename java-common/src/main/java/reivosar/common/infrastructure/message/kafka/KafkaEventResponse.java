package reivosar.common.infrastructure.message.kafka;

import reivosar.common.event.EventResponse;
import reivosar.common.util.communication.response.ResponseData;
import reivosar.common.util.communication.response.ResponseHeaders;
import reivosar.common.util.communication.response.ResponseStatus;
import reivosar.common.util.lang.TimeMeasurement;

public class KafkaEventResponse implements EventResponse
{
    private final ResponseStatus status;
    private final ResponseHeaders responseHeaders;
    private final ResponseData responseData;
    private final TimeMeasurement timeMeasurement;

    public KafkaEventResponse(
        final ResponseStatus status,
        final ResponseHeaders responseHeaders,
        final ResponseData responseData,
        final TimeMeasurement timeMeasurement)
    {
        this.status          = status;
        this.responseHeaders = responseHeaders;
        this.responseData    = responseData;
        this.timeMeasurement = timeMeasurement;
    }

    public KafkaEventResponse(
        final ResponseStatus status,
        final TimeMeasurement timeMeasurement)
    {
        this(status, new ResponseHeaders(), new ResponseData(), timeMeasurement);
    }

    @Override
    public ResponseStatus status() {
        return status;
    }

    @Override
    public ResponseHeaders headers() {
        return responseHeaders;
    }

    @Override
    public ResponseData data() {
        return responseData;
    }

    @Override
    public long startTime() {
        return timeMeasurement.startTime();
    }

    @Override
    public long endTime() {
        return timeMeasurement.endTime();
    }
}
