package me.glux.forward.server;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by gx on 2016/8/10.
 */
public class Listener {

    public void start() throws IOException {
        Socket client=new Socket("127.0.0.1",5000);
        client.getOutputStream();

    }
}
