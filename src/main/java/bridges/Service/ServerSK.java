package bridges.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Random;

import bridges.Service.ClientThread;

public class ServerSK {
    private ServerSocket serverSocket = null;    // 在服务器上开一个套筒
    private Socket clientSocket = null;
    private static int maxClientCount = 4;       // max number of connected client threads
//    private SocketAddress bindAddress = null;    // SocketAddress is an abstract class
    private InetSocketAddress bindAddress = null;

    public ServerSK(String bindAddress, int bindPort) {
        this.bindAddress = new InetSocketAddress(bindAddress, bindPort);
    }

    public void runServer(){
        try {
            serverSocket = new ServerSocket();     // initialize ServerSocket
            serverSocket.bind(this.bindAddress);   // bind IP address and port
        } catch (IOException e) {
            e.printStackTrace();
        }

        // creat client threads
        new Thread(){
            @Override
            public void run() {
                super.run();
                for (int count = 0; count < maxClientCount; count++){
                    try {
                        clientSocket = serverSocket.accept();  // serverSocket.accept() return a Socket type object
                        System.out.println("client have connected");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public static void setMaxClientCount(int maxClientCount) {
        ServerSK.maxClientCount = maxClientCount;
    }

    // for pass address and port number to client socket
    public InetSocketAddress getBindAddress() {
        return bindAddress;
    }
}
