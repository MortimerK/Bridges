package bridges.Service;

import bridges.Service.ServerSK;
import bridges.Service.ClientThread;

public class SmallMain {
    public static void main(String[] args) {
        ServerSK sk = new ServerSK("127.0.0.1", 6683);
        sk.runServer();

//        System.out.println("what the hell");
        new ClientThread(sk.getBindAddress()).start();
        new ClientThread(sk.getBindAddress()).start();
        new ClientThread(sk.getBindAddress()).start();
        new ClientThread(sk.getBindAddress()).start();
    }
}
