package com.IssaDev.SpringRest.Rest.services.with.Spring.ExceptionHandlers;

import java.util.Date;

public class ExceptionClass {
        private Date timestamp;
        private String message;
        private String details;

        public Date getTimestamp() {
            return timestamp;
        }

        public String getMessage() {
            return message;
        }

        public String getDetails() {
            return details;
        }

        public ExceptionClass(Date timestamp, String message, String details) {
            this.timestamp = timestamp;
            this.message = message;
            this.details = details;
        }
}


