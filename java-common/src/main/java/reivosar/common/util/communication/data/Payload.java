package reivosar.common.util.communication.data;

public interface Payload
{
    PayloadType getType();

    PayloadData getData();
}
