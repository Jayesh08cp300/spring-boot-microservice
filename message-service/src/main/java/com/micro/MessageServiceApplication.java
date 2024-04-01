package com.micro;

import com.micro.event.AlertMessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class MessageServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MessageServiceApplication.class, args);
	}

	@KafkaListener(topics = "messageTopic", groupId = "messageGroupId")
	public void handleNotification(AlertMessageEvent alertMessageEvent) {
		log.info("Message received -> <{}> ", alertMessageEvent.getMessage());
		// send out an email notification
	}
}
