package reivosar.common.util.communication.data;

public interface Data extends Iterable<Payload>
{
    Data add(final Payload payload);

    Payload[] toArray();
}
