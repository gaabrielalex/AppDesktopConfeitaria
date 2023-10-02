/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.util.custom_components;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Gabriel
 */
public class TESTConfirmationDeleteRecordDialog {
    //Atributos
    private final JDialog dialog;
    private final Image iconImg;
    
    //Constructor setando estrutura padrão do dialog
    public TESTConfirmationDeleteRecordDialog(JFrame previousView){
        /*Cria um dialog para confirmar a exclusão do registro, 
        configurando-o toda a sua estrutura necessária*/
        this.dialog = new JDialog();
        this.iconImg = new BufferedImage(1, 1,BufferedImage.TYPE_INT_ARGB_PRE);
        this.dialog.setIconImage(iconImg);
        this.dialog.setDefaultCloseOperation(2);
        this.dialog.setTitle("Confirmation");
 
        //Testes
        this.dialog.setSize(380, 130);

        //Configurando o posicionamento do dialog como centralizado
        this.dialog.setLocationRelativeTo(null); 
        
        /*Habilita a tela anterior quando o dialog for fechado(por meio de um window listener
        que modificará o evento 'windowClosing' da janela)*/
        this.dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //Habilita a tela anterior quando a nova página for fechada
                previousView.setEnabled(true);
            }
        });
    }

    //Apenas o getter, o dialog só é definido pelo constructor
    public JDialog getDialog() {
        return this.dialog;
    }
    
}
