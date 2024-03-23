package com.hack.listener;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SessionListener extends Thread {

    private ConnectionInterface connectionInterface; // Geri çağırım için listener
    private final GetOutput getOutput;
    private final int in_port;
    private final String in_ip;
    private ServerSocket serverSocket;

    public SessionListener(int port, String ip) {
        this.getOutput = new GetOutput();
        this.in_port = port;
        this.in_ip = ip;
    }

    @Override
    public void run() {
        listening();
    }

    public void setConnectionListener(ConnectionInterface listener) {
        this.connectionInterface = listener;
    }

    public void listening() {

        try {
            serverSocket = new ServerSocket(in_port, 0, InetAddress.getByName(in_ip));
            while (!serverSocket.isClosed()) {
                try {
                    Socket socket = serverSocket.accept();
                    String hostname = getOutput.jsonRecv(socket).replaceAll("\"", "");
                    if (connectionInterface != null) {
                        connectionInterface.onConnection(socket, hostname);
                    }
                } catch (SocketException e) {System.out.println(e);}
            }

        } catch (IOException e) {
            ErrorDialog.showError("Hata olustu");
            System.out.println(e);
        }
    }

    public void stopListening() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
                System.out.println("Server socket closed.");
            }
        } catch (IOException e) {
            ErrorDialog.showError("Hata olustu");
            System.out.println(e);
        }
    }
}
