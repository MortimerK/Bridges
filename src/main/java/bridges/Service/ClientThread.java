package bridges.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

// implements one client to one thread
public class ClientThread extends Thread {
    private Socket clientSocket = null;    // 在用户主机上开一个套筒
    private SocketAddress bindAddress = null;
    private int portNumber = 0;

    @Override
    public void run() {
        super.run();
        try {
            clientSocket = new Socket();
            clientSocket.connect(bindAddress);
//            System.out.println(clientSocket.isConnected());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // wait for serverSK instance pass bindAddress to ClientThread
    public ClientThread(InetSocketAddress bindAddress) {
//        this.bindAddress = bindAddress.getAddress();   // getAddress() method return a InetAddress type object
//        this.portNumber = bindAddress.getPort();       // getPort() method return an int type variable
        this.bindAddress = bindAddress;
    }

}
