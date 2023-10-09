package edu.ifmt.confeitaria.util;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UtilResources {
    public static String SPECIAL_CHARACTERS= " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    public static String NUMBERS = "0123456789";
    public static Long MAX_ID_VALUE = 2147483647L;

    public static void allowOnlyPositiveNumbers(JTextField field) {
        String fieldText = field.getText();
        for (int i = 0; i < fieldText.length(); i++) {
            if(fieldText.equals("0")) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        field.setText("");
                    }
                });
            } else if(!UtilResources.NUMBERS.contains(fieldText.charAt(i) + "")) {
                final String newFielText = fieldText.replace(String.valueOf(fieldText.charAt(i)), "");

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        field.setText(newFielText);
                    }
                });
            }
        }  
    }
    
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
