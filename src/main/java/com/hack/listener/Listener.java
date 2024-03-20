package com.hack.listener;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URISyntaxException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Listener {
    
    public static void main(String args[]) throws URISyntaxException {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( UnsupportedLookAndFeelException e ) {
            ErrorDialog.showError("Hata olustu");
            System.out.println(e);
        }
        
        // Pencereyi oluştur ve görünür hale getir
        java.awt.EventQueue.invokeLater(() -> {
            UI ui = new UI();
            ui.setVisible(true);
            
            ui.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    try {ui.listenerClosed();}catch(Exception e){System.out.println(e);}
                    try {ui.tunnelStop();}catch(Exception e){System.out.println(e);}
                }
            });
        });
    }
    
}
