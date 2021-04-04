package reivosar.common.domain.model.event;

import reivosar.common.util.concurrent.promise.Promise;
import reivosar.common.util.model.Identity;

public interface DomainEventPublisher
{
	<ID extends Identity<ID>, ENTITY extends EventableEntity<ID, ENTITY>>
	void asyncPublish(ENTITY entity);

	<ID extends Identity<ID>, ENTITY extends EventableEntity<ID, ENTITY>>
	Promise<Object> awaitPublish(ENTITY entity);
}
