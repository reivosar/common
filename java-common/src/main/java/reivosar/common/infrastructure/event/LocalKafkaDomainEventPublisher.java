package reivosar.common.infrastructure.event;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import reivosar.common.domain.model.EventableEnity;
import reivosar.common.domain.model.Identity;
import reivosar.common.domain.model.event.Event;
import reivosar.common.domain.service.event.DomainEventPublisher;
import reivosar.common.util.JsonUtils;
import reivosar.common.util.concurrent.promise.Promise;

@Component
public class LocalKafkaDomainEventPublisher implements DomainEventPublisher
{
	@Autowired
	private final KafkaTemplate<String, String> template;

	public LocalKafkaDomainEventPublisher(KafkaTemplate<String, String> template) {
		this.template = template;
	}

	@Override
	public <ID extends Identity<ID>, ENTITY extends EventableEnity<ID, ENTITY>>
	void asyncPublish(ENTITY entity)
	{
		Promise.single()
			.then  (eventSuppliers(entity.allEvents()))
			.async ();
	}

	@Override
	public <ID extends Identity<ID>, ENTITY extends EventableEnity<ID, ENTITY>>
	void awaitPublish(ENTITY entity)
	{
		Promise.single()
			.then  (eventSuppliers(entity.allEvents()))
			.await ();
	}

	private Collection<Supplier<Object>> eventSuppliers(final Collection<Event> events) {
		return 	events.stream()
				.map(event -> new Supplier<Object> () {
					@Override
					public Object get() {
						return template.send(event.eventTopic().asString(),
								             JsonUtils.toJson(event));
					}
				}).collect(Collectors.toUnmodifiableList());
	}
}
