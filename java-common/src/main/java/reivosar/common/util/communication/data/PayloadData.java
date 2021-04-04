package reivosar.common.util.communication.data;

import reivosar.common.util.model.ValueObject;

public class PayloadData extends ValueObject<PayloadData>
{
    final byte[] binary;

    public PayloadData(byte[] binary) {
        this.binary = binary;
    }
}
