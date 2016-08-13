package me.glux.forward;

import me.glux.forward.exception.UnknownMessageTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gx on 2016/8/13.
 */
public class MessageTypeDispatcher {
    private static final Logger logger= LoggerFactory.getLogger(MessageTypeDispatcher.class);
    private final Map<MessageType,MessageTypeHandler> handlers=new HashMap<>();

    public void register(MessageType type,MessageTypeHandler handler){
        handlers.put(type,handler);
    }

    public void dispatch(DataInputStream dis) throws IOException{
        int typeCode=dis.readInt();
        MessageType type;
        try {
            type=MessageType.getByCode(typeCode);
        } catch (UnknownMessageTypeException e) {
            logger.warn("Unknown message type, code="+typeCode+", message will be read out and drop.");
            readOutInvalidFrame(dis);
            return;
        }
        MessageTypeHandler handler=handlers.get(type);
        if(handler == null){
            logger.warn("No valid handler for message type="+handler.toString()+", message will be read out and drop.");readOutInvalidFrame(dis);
            return;
        }

        handler.handle(dis);
    }


    private static final int BUFFER_SIZE=4096;
    public void readOutInvalidFrame(DataInputStream dis) throws IOException {
        int length=dis.readInt();
        byte[] buffer=new byte[BUFFER_SIZE];
        int readCountOnce;
        while(length > 0){
            if(length > BUFFER_SIZE){
                readCountOnce=BUFFER_SIZE;
            }else{
                readCountOnce=length;
            }
            readCountOnce=dis.read(buffer,0,readCountOnce);
            length=length - readCountOnce;
        }
    }
}
