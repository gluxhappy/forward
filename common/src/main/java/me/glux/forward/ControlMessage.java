package me.glux.forward;

/**
 * Created by gx on 2016/8/13.
 */
public class ControlMessage implements Message{
    @Override
    public MessageType getMessageType() {
        return MessageType.CONTROL;
    }

    @Override
    public byte[] nextPart() {
        return new byte[0];
    }
}
