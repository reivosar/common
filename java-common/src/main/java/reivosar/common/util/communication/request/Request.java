package reivosar.common.util.communication.request;

public interface Request
{
    ResquestHeaders headers();

    RequestData data();
}
