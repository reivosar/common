package reivosar.common.util.communication.response;

public interface Response
{
    ResponseStatus state();

    ResponseHeaders headers();

    ResponseData data();
}
