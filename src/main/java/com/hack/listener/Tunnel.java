package com.hack.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Tunnel extends Thread {

    Process process;
    private TunnelInterface tunnelInterface;
    private final String command;

    public Tunnel(String command) {
        this.command = command;
    }

    public void setTunnelListener(TunnelInterface tunnelListener) {
        this.tunnelInterface = tunnelListener;
    }

    @Override
    public void run() {
        startTunnel();
    }

    public void startTunnel() {
        try {
            process = Runtime.getRuntime().exec(command);
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Standart hata akışı
            InputStream errorStream = process.getErrorStream();
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));

            String line;
            while (!process.waitFor(1, TimeUnit.SECONDS)) {
                while (reader.ready() && (line = reader.readLine()) != null) {
                    if (tunnelInterface != null) {
                        tunnelInterface.onTunnel(line);
                    }
                }

                // Hata akışından okuma
                StringBuilder errorOutput = new StringBuilder();
                while (errorReader.ready() && (line = errorReader.readLine()) != null) {
                    errorOutput.append(line).append("\n");
                }

                // Hata akışını yazdırın
                if (errorOutput.length() > 0) {
                    if (tunnelInterface != null) {
                        tunnelInterface.onTunnel(errorOutput.toString());
                    }
                }
            }

            // İşlemi bekleyin ve çıkış kodunu kontrol edin
            int exitCode = process.waitFor();
            System.out.println("Tunnel process exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void stopTunnel(){
        process.destroy();
    }
    
}
