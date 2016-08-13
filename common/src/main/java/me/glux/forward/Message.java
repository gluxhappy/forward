package me.glux.forward;

/**
 * Created by gx on 2016/8/13.
 */
public interface Message {
    MessageType getMessageType();
    byte[] nextPart();
}
