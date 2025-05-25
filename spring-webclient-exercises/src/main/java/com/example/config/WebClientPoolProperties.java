package com.example.config;

import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "webclient.pool")
public class WebClientPoolProperties {
    private int maxConnections;
    private int pendingAcquireMaxCount;
    private Duration pendingAcquireTimeout;
	public int getMaxConnections() {
		return maxConnections;
	}
	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}
	public int getPendingAcquireMaxCount() {
		return pendingAcquireMaxCount;
	}
	public void setPendingAcquireMaxCount(int pendingAcquireMaxCount) {
		this.pendingAcquireMaxCount = pendingAcquireMaxCount;
	}
	public Duration getPendingAcquireTimeout() {
		return pendingAcquireTimeout;
	}
	public void setPendingAcquireTimeout(Duration pendingAcquireTimeout) {
		this.pendingAcquireTimeout = pendingAcquireTimeout;
	}

    
}
