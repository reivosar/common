package reivosar.common.infrastructure.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reivosar.common.domain.model.message.Message;
import reivosar.common.domain.model.message.MessageId;
import reivosar.common.domain.model.message.MessageReposiory;
import reivosar.common.domain.service.event.DomainEventPublisher;
import reivosar.common.util.log.Loggers;

@Component
public class DomainEventMessageRepository implements MessageReposiory {

	private static final Loggers loggers = Loggers.getLoggers(DomainEventMessageRepository.class);

	@Autowired
    private final DomainEventPublisher domainEventPublisher;

	public DomainEventMessageRepository(DomainEventPublisher domainEventPublisher) {
		this.domainEventPublisher = domainEventPublisher;
	}

	@Override
	public MessageId generateId() {
		return new MessageId();
	}

	@Override
	public void save(Message message) {
		loggers.info("Event publishing start: publicId:" + message.publicId());
		domainEventPublisher
			.awaitPublish(message)
			.onSuccess(
				result -> loggers.debug("Event publishing success. "
					+ "event:" + message.toString() +
					" ,result:" + result.toString())
			)
			.onFailure(
				t -> loggers.error("Event publishing error.", t)
			);
		loggers.info("Event publishing end: publicId:" + message.publicId());
	}
}
