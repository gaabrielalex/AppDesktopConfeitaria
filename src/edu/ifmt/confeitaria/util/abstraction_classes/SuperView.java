/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.util.abstraction_classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Optional;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Gabriel
 */
public abstract class SuperView extends javax.swing.JFrame{
    //Atributos
    private static final Color DEFAULT_BACKGROUND_COLOR = new Color(237, 237, 237);
      
    //Constructors   
    
    //Getters e Setters 
     
    //Métodos
    public void setDefaultViewSettings(String title, JFrame previousView) {
        this.setLocationRelativeTo(null); 
        this.setTitle(title);
        this.setDefaultCloseOperation(2);
        this.setResizable(false);    
        this.getContentPane().setBackground(DEFAULT_BACKGROUND_COLOR);

        /*Define a cor de fundo padrão de todos os JPanels da view*/
        SuperView.setPanelsDefaultBackgroundColor(this);
        SuperView.setDefaulTableSettings(this);

        if(previousView != null){
            /* Desabilita a tela anterior para que não seja possível interagir com ela */
            previousView.setEnabled(false);
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    //Habilita a tela anterior quando a nova página for fechada
                    previousView.setEnabled(true);
                }
            });
        } 
        
    }
    
    //Método para definir a cor de fundo padrão dos JPanels
    public static void setPanelsDefaultBackgroundColor(JFrame currentView) {
        // Itera sobre todos os componentes do JFrame
        for (Component c : currentView.getContentPane().getComponents()) {
            // Verifica se o componente é um JPanel
            if (c instanceof JPanel) {
                // Define a cor do background do JPanel como a cor de fundo padrão do app
                c.setBackground(SuperView.DEFAULT_BACKGROUND_COLOR);
                /* Chama o método recursivamente para os JPanels
               que podem estar dentro de outros JPanels */
                SuperView.setPanelsDefaultBackgroundColor((JPanel) c);
            }
         }
    }
    
    /*Método para definir a cor de fundo padrão dos JPanels
    que podem estar dentro de outros JPanels*/
    public static void setPanelsDefaultBackgroundColor(JPanel panel) {
        /*Itera sobre todos os componentes do JPanel paraprocurar por outros JPanels*/
        for (Component c : panel.getComponents()) {
            // Verifica se o componente é um JPanel
            if (c instanceof JPanel) {
                // Define a cor do background do JPanel como a cor de fundo padrão do app
                c.setBackground(SuperView.DEFAULT_BACKGROUND_COLOR);
                /* Chama o método recursivamente para os JPanels
                que podem estar dentro de outros JPanels */
                SuperView.setPanelsDefaultBackgroundColor((JPanel) c);
            }
         }
    }
    
    public static void setDefaulTableSettings(JFrame currentView) {
        Optional<JTable> table = SuperView.getJTableInView(currentView);

        if (table.isPresent()) {
            JTable jTable = table.get();
            // Desabilita a edição das células da tabela
            jTable.setDefaultEditor(Object.class, null); 
        } else {
            // A tabela não foi encontrada
        } 
    }
    
    public static Optional<JTable> getJTableInView(Component component) {
        // Se o componente for um JTable, retorna ele
        if (component instanceof JTable) {
            return Optional.of((JTable) component);
        }

        // Se o componente for um container, itera sobre seus filhos
        if (component instanceof Container) {
            Container container = (Container) component;
            for (Component child : container.getComponents()) {
                Optional<JTable> table = getJTableInView(child);
                if (table.isPresent()) {
                    return table;
                }
            }
        }

        // Se não encontrou nenhum JTable, retorna null
        return Optional.empty();
    }
    
}
