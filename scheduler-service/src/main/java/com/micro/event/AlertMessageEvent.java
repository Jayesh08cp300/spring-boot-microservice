package com.micro.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class AlertMessageEvent extends ApplicationEvent {
	private String message;

	public AlertMessageEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	public AlertMessageEvent(String message) {
		super(message);
		this.message = message;
	}
}
