package com.micro.scheduler;

import com.micro.event.AlertMessageEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageScheduler {

	private final KafkaTemplate<String, AlertMessageEvent> kafkaTemplate;

	@Scheduled(fixedRate = 5000)
	public void sendMessage() {
		kafkaTemplate.send("messageTopic", new AlertMessageEvent(RandomStringUtils.random(10, true, false)));
	}

	@Scheduled(cron = "*/5 * * * * *")
	public void sendMessage2() {
		kafkaTemplate.send("messageTopic", new AlertMessageEvent(RandomStringUtils.random(10, false, true)));
	}
}
