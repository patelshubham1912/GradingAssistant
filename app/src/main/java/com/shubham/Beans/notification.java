package com.shubham.Beans;

/**
 * Created by $hubham on 22/11/2016.
 */

public class notification {

    private String sender_id;
    private String sender_email_id;
    private String message;
    private String receiver_id;
    private String receiver_email_id;

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getSender_email_id() {
        return sender_email_id;
    }

    public void setSender_email_id(String sender_email_id) {
        this.sender_email_id = sender_email_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getReceiver_email_id() {
        return receiver_email_id;
    }

    public void setReceiver_email_id(String receiver_email_id) {
        this.receiver_email_id = receiver_email_id;
    }
}
