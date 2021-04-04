package reivosar.common.util.communication.response;

public interface Response
{
    ResponseStatus status();

    ResponseHeaders headers();

    ResponseData data();
}
