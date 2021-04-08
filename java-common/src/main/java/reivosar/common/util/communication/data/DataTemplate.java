package reivosar.common.util.communication.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public abstract class DataTemplate implements Data
{
    private static final Payload[] EMPTY_PAYLOADS = new Payload[0];

    private final List<Payload> payloads;

    public DataTemplate() {
        this(new ArrayList<Payload>());
    }

    public DataTemplate(final List<Payload> payloads) {
        if (payloads == null) {
            this.payloads = new ArrayList<>();
        } else {
            this.payloads = new ArrayList<>(payloads);
        }
    }

    @Override
    public Iterator<Payload> iterator() {
        return payloads.iterator();
    }

    @Override
    public Data add(final Payload payload) {
        checkPayload(payload);
        this.payloads.add(payload);
        return this;
    }

    @Override
    public Payload[] toArray() {
        return payloads.isEmpty() ? EMPTY_PAYLOADS : payloads.toArray(new Payload[payloads.size()]);
    }

    private void checkPayload(final Payload payload) {
        Objects.requireNonNull(payload, "payload cannot be null.");
    }
}
