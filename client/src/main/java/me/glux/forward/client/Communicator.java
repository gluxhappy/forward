package me.glux.forward.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by gx on 2016/8/12.
 */
public class Communicator {

    public void start() throws IOException {
        Socket socket=new Socket("127.0.0.1",10086);
        DataInputStream dis=new DataInputStream(socket.getInputStream());
        DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
    }

    public void sendToServer(){

    }
}
