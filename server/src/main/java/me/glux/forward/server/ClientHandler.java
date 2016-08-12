package me.glux.forward.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

/**
 * Created by gx on 2016/8/11.
 */
public class ClientHandler implements Runnable {

    private Socket source;

    public ClientHandler(Socket socket) {
        this.source = socket;
    }

    public void run() {
        try {
        } catch (Exception e) {

        }
    }

    public void init() {

    }

    public void handshake() throws IOException {
        DataInputStream dis = new DataInputStream(source.getInputStream());
        int msgTypeCode = dis.readUnsignedByte();
        MessageType msgType = MessageType.getByCode(msgTypeCode);
        int length = dis.readInt();
        if (length > 0) {
            byte[] data = new byte[length];
            int read = 0;
            int readOnce ;
            do {
                int left = length - read;
                readOnce = dis.read(data, read, left);
                read += readOnce;
            } while (read < length);
        }
        switch (msgType) {
            case Protocol: {
                break;
            }
            case Carriage: {
                break;
            }
            default: {
                //
            }
        }
    }

    private void forward(int client,int port,byte[] data){

    }

}
