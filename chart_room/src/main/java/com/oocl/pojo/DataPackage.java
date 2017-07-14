package com.oocl.pojo;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class DataPackage {
    private String from;
    private String to;
    private MessageType messageType;
    private String messageData;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getMessageData() {
        return messageData;
    }

    public void setMessageData(String messageData) {
        this.messageData = messageData;
    }
}

enum MessageType {
    TEXT, SHAKE
}
