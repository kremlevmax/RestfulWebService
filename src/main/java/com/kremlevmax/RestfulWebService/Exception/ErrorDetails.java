package com.kremlevmax.RestfulWebService.Exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message, details;
	
	public ErrorDetails(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.details = details;
		this.message = message;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getDescription() {
		return details;
	}
	public void setDescription(String description) {
		this.details = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ErrorDetails [timestamp=" + timestamp + ", description=" + details + ", message=" + message + "]";
	}
}
