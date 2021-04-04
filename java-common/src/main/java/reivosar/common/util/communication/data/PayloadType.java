package reivosar.common.util.communication.data;

import reivosar.common.util.model.ValueObject;

public class PayloadType extends ValueObject<PayloadType>
{
    public enum Type {
        STRING, JSON, PROTO
    }
}
