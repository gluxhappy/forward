package me.glux.forward.server;

/**
 *   |1b|1b|2b|
 * Created by gx on 2016/8/10.
 */
public enum MessageType {
    Protocol((byte)0x01),
    Carriage((byte)0x02);

    private byte code;
    MessageType(byte code){
        this.code=code;
    }
}
