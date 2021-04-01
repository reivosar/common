package reivosar.common.domain.service.event;

import reivosar.common.domain.model.Identity;
import reivosar.common.domain.model.event.EventableEntity;
import reivosar.common.util.concurrent.promise.Promise;

public interface DomainEventPublisher
{
	<ID extends Identity<ID>, ENTITY extends EventableEntity<ID, ENTITY>>
	void asyncPublish(ENTITY entity);

	<ID extends Identity<ID>, ENTITY extends EventableEntity<ID, ENTITY>>
	Promise<Object> awaitPublish(ENTITY entity);
}
