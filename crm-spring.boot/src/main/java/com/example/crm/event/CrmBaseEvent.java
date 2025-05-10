package com.example.crm.event;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.apache.kafka.common.Uuid;

public abstract class CrmBaseEvent {
	private final String eventId = Uuid.randomUuid().toString();
	private final long timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
	private final CrmEventType eventType;

	public CrmBaseEvent(CrmEventType eventType) {
		this.eventType = eventType;
	}

	public String getEventId() {
		return eventId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public CrmEventType getEventType() {
		return eventType;
	}

	@Override
	public String toString() {
		return "CrmBaseEvent [eventId=" + eventId + ", timestamp=" + timestamp + ", eventType=" + eventType + "]";
	}

}
