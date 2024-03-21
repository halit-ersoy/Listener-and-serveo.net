package com.hack.listener;

import java.util.List;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class SessionList {
    
    private final List<Socket> sessionList = new ArrayList<>();
    private final JList jList;
    private final DefaultListModel model;
    
    public SessionList(JList jList) {
        this.model = new DefaultListModel<>();
        this.jList = jList;
    }
    
    public void sessionList(Socket socket, String hostname){
        jList.setModel(model);
        sessionList.add(socket);
        model.addElement("Connection from: " + socket.getInetAddress() + ":" + socket.getPort() + " | " + hostname);
    }
    
    public Socket selectedSocket(){
        return sessionList.get(jList.getSelectedIndex());
    }
    
    public void deleteSession(){
        int index = jList.getSelectedIndex();
        model.remove(index);
        sessionList.remove(index);
    }
    
    public void deleteAllSession(){
        model.removeAllElements();
        sessionList.removeAll(sessionList);
    }
    
}
