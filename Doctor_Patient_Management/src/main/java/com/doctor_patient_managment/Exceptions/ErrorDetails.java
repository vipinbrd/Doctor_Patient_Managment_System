package com.doctor_patient_managment.Exceptions;

import java.time.LocalDateTime;

public class ErrorDetails {

		
		private LocalDateTime timestamp;
		private String message;
		private String description;
		public LocalDateTime getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

	
}
