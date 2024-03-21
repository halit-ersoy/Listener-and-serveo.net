package com.hack.listener;

import javax.swing.JOptionPane;

public class ErrorDialog {
    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
