package reivosar.common.event;

import reivosar.common.util.communication.response.Response;

public interface EventResponse extends Response
{
    long startTime();

    long endTime();
}
