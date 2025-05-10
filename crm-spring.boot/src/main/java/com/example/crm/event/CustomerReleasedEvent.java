package com.example.crm.event;

public class CustomerReleasedEvent extends CrmBaseEvent {
	private final String identity;

	public CustomerReleasedEvent(String identity) {
		super(CrmEventType.CUSTOMER_RELEASED_EVENT);
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}

	@Override
	public String toString() {
		return "CustomerAcquiredEvent [identity=" + identity + "]";
	}

}
