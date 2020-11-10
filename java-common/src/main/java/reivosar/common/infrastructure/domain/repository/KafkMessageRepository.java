package reivosar.common.infrastructure.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reivosar.common.domain.model.message.Message;
import reivosar.common.domain.model.message.MessageId;
import reivosar.common.domain.model.message.MessageReposiory;
import reivosar.common.domain.service.event.EventPublisher;
import reivosar.common.util.log.Loggers;

@Component
public class KafkMessageRepository implements MessageReposiory {

	private static final Loggers loggers = Loggers.getLoggers(KafkMessageRepository.class);

    private final EventPublisher eventPublisher;

    @Autowired
	public KafkMessageRepository(EventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@Override
	public MessageId generateId() {
		return new MessageId();
	}

	@Override
	public void save(Message message) {
		loggers.info("start");
		eventPublisher.asyncPublish(message);
		loggers.info("end");
	}
}
