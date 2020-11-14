package reivosar.common.domain.service.event;

import reivosar.common.domain.model.EventableEnity;
import reivosar.common.domain.model.Identity;
import reivosar.common.util.concurrent.promise.Promise;

public interface DomainEventPublisher
{
	<ID extends Identity<ID>, ENTITY extends EventableEnity<ID, ENTITY>>
	void asyncPublish(ENTITY entity);

	<ID extends Identity<ID>, ENTITY extends EventableEnity<ID, ENTITY>>
	Promise<Object> awaitPublish(ENTITY entity);
}
