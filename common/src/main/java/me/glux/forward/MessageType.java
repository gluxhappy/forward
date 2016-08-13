package me.glux.forward;

import me.glux.forward.exception.UnknownMessageTypeException;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gx on 2016/8/13.
 */
public enum MessageType {
    CONTROL(1),
    DATA(2);

    public final int code;

    MessageType(int code){
        this.code=code;
    }

    private static final Map<Integer,MessageType> cache;
    static {
        cache=new HashMap<>();
        for(MessageType type : EnumSet.allOf(MessageType.class)){
            cache.put(Integer.valueOf(type.code),type);
        }
    }
    public static final MessageType getByCode(int code) throws UnknownMessageTypeException{
        MessageType type=cache.get(Integer.valueOf(code));
        if(type == null){
            throw new UnknownMessageTypeException();
        }
        return type;
    }
}
