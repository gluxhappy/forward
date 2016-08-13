package me.glux.forward;

/**
 * Created by gx on 2016/8/13.
 */
public class DataMessage implements Message{
    @Override
    public MessageType getMessageType() {
        return MessageType.DATA;
    }

    @Override
    public byte[] nextPart() {
        return new byte[0];
    }
}
