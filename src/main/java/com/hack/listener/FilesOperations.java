package com.hack.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Base64;
import javax.swing.JFileChooser;

public class FilesOperations {
    
    private final Socket socket;
    private CommandSend send;
    
    public FilesOperations(Socket socket) {
        this.socket = socket;
    }
    
    private File fileChooser(int jFileChooser) {
        
        // Dosya seçiciyi oluşturuyoruz.
        JFileChooser fileChooser = new JFileChooser();

        // Sadece dizinleri seçmesini sağlıyoruz.
        fileChooser.setFileSelectionMode(jFileChooser);

        // Dosya seçici penceresini açıyoruz ve kullanıcının seçimini alıyoruz.
        int returnValue = fileChooser.showOpenDialog(null);

        // Kullanıcı bir dosya seçtiyse devam ediyoruz.
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile;
        } else {
            return null;
        }
    }
    
    public void upload() throws IOException{
        File selectedFile = fileChooser(JFileChooser.FILES_ONLY);
        if (selectedFile != null) {
            String filePath = selectedFile.getAbsolutePath();
            String fileName = selectedFile.getName();
            String fileData = readFile(filePath);
            send = new CommandSend(socket, "upload " + fileName + " " + fileData);
            send.commandExecution();
        }
    }
    
    public void download(String fileName) throws IOException {
        File selectedFile = fileChooser(JFileChooser.DIRECTORIES_ONLY);
        if (selectedFile != null) { // Kontrol ekleyin: Eğer kullanıcı bir dosya seçmediyse, devam etmeyin
            String filePath = selectedFile.getAbsolutePath();
            send = new CommandSend(socket, "download " + fileName);
            String data = send.commandExecution().toString().replaceAll("\"", "");
            saveFile(filePath + "\\" + fileName, data);
        }
    }
    
    private String readFile(String path) {
        try {
            File file = new File(path);
            byte[] bytesArray = new byte[(int) file.length()];
            try (FileInputStream fis = new FileInputStream(file)) {
                fis.read(bytesArray);
            }
            return Base64.getEncoder().encodeToString(bytesArray);
        } catch (IOException e) {
            ErrorDialog.showError("Hata olustu");
            System.out.println(e);
            return null;
        }
    }

    private void saveFile(String path, String data) throws IOException {
        byte[] decodedBytes = Base64.getDecoder().decode(data);
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(decodedBytes);
        }
        System.out.println("Download successful: " + path);
    }
    
}
