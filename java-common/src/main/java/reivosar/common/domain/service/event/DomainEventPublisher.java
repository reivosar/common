package reivosar.common.domain.service.event;

import reivosar.common.domain.model.EventableEnity;
import reivosar.common.domain.model.Identity;

public interface DomainEventPublisher
{
	<ID extends Identity<ID>, ENTITY extends EventableEnity<ID, ENTITY>>
	void asyncPublish(ENTITY entity);

	<ID extends Identity<ID>, ENTITY extends EventableEnity<ID, ENTITY>>
	void awaitPublish(ENTITY entity);
}
