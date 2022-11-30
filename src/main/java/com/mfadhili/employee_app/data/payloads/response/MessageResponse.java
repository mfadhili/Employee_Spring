package com.mfadhili.employee_app.data.payloads.response;
/**
 * This is a simple Plain Old Java Object (POJO) with one instance variable, a constructor, a mutator (setter) and accessor (getter)
 * */

public class MessageResponse {
    private String message;

    /** Constructor*/
    public MessageResponse(String message) {
        this.message = message;
    }

    /** Getters and setters*/
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
