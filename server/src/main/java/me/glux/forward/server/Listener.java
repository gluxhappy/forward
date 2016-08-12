package me.glux.forward.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by gx on 2016/8/10.
 */
public class Listener {

    private Executor executor= Executors.newFixedThreadPool(20);
    public void start() throws IOException {
        ServerSocket serverSocket=new ServerSocket(10086,20);
        do {
            Socket client = serverSocket.accept();
            executor.execute(new ClientHandler(client));
        }while (true);

    }
}
