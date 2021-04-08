package reivosar.common.infrastructure.message;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reivosar.common.domain.model.event.DomainEventPublisher;
import reivosar.common.domain.model.event.Event;
import reivosar.common.domain.model.event.EventableEntity;
import reivosar.common.event.EventBus;
import reivosar.common.util.concurrent.promise.Promise;
import reivosar.common.util.model.Identity;

@Component("MessagingDomainEventPublisher")
public class MessagingDomainEventPublisher implements DomainEventPublisher
{
    private final EventBus eventBus;

    @Autowired
    public MessagingDomainEventPublisher(final EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public <ID extends Identity<ID>, ENTITY extends EventableEntity<ID, ENTITY>>
    void asyncPublish(final ENTITY entity)
    {
        Objects.requireNonNull(entity, "entity must not be null");
        Promise.single()
            .then  (eventSuppliers(entity.allEvents()))
            .async ();
    }

    @Override
    public <ID extends Identity<ID>, ENTITY extends EventableEntity<ID, ENTITY>>
    Promise<Object> awaitPublish(final ENTITY entity)
    {
        Objects.requireNonNull(entity, "entity must not be null");
        return Promise.single()
                .then  (eventSuppliers(entity.allEvents()))
                .await ();
    }

    private Collection<Supplier<Object>> eventSuppliers(final Collection<Event> events) {
        return  events.stream()
                .map(event -> new Supplier<Object> () {
                    @Override
                    public Object get() {
                        return eventBus.publish(event);
                    }
                }).collect(Collectors.toUnmodifiableList());
    }
}
