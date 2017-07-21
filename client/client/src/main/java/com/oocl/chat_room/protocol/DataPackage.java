package com.oocl.chat_room.protocol;

import java.io.Serializable;

/*
 * protocol
 * fromName:message sender;
 * toName:message receiver
 * messageType: LONGIN   user login
 * 				LONGOUT  user logout
 * 				LIST  "\" Cutting operator
 * 				MESSAGE chat message
 * 				SHAKE   windows shake
 */
public class DataPackage implements Serializable {

    public enum MessageType {
        LOGIN, LOGOUT, LIST, MESSAGE, SHAKE,REGISTER
    }

    public DataPackage() {

    }

    public DataPackage(String fromName, String toName, MessageType messageType, String messageData) {
        super();
        this.fromName = fromName;
        this.toName = toName;
        this.messageType = messageType;
        this.messageData = messageData;
        this.time = time;
    }

    public DataPackage(String fromName, String toName, MessageType messageType, String messageData, long time) {
        super();
        this.fromName = fromName;
        this.toName = toName;
        this.messageType = messageType;
        this.messageData = messageData;
        this.time = time;
    }

    private static final long serialVersionUID = 1L;
    private String fromName;
    private String toName;
    private MessageType messageType;
    private String messageData;
    private long time;

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "DataPackage [fromName=" + fromName + ", toName=" + toName
                + ", messageType=" + messageType + ", messageData="
                + messageData + ", time=" + time + "]";
    }
}