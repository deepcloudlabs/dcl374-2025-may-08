package com.example.crm.event;

public class CustomerAcquiredEvent extends CrmBaseEvent {
	private final String identity;

	public CustomerAcquiredEvent(String identity) {
		super(CrmEventType.CUSTOMER_ACQUIRED_EVENT);
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
