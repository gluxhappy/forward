package me.glux.forward.server;

/**
 *   |1b|1b|2b|
 * Created by gx on 2016/8/10.
 */
public enum MessageType {
    Protocol(1),
    Carriage(2);

    private final int code;
    MessageType(int code){
        this.code=code;
    }

    public static MessageType getByCode(int code){
        // TODO to implement
        return null;
    }
}
