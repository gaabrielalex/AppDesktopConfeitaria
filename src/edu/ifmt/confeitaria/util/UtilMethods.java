package edu.ifmt.confeitaria.util;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UtilMethods {
    
    public static void addTextChangeListeners(JTextField field, Runnable action) {
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                action.run();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                action.run();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                action.run();
            }
        });
    }
}
