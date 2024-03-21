package com.hack.listener;

import java.net.Socket;

public interface ConnectionInterface {
    void onConnection(Socket socket, String hostname);
}
