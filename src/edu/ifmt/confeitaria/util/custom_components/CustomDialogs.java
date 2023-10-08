/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.util.custom_components;

import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class CustomDialogs {
    
    public static boolean ConfirmationDeleteRecord() {
        //Cria um array de opções para o dialog
        Object[] options = { "Ok", "Cancelar" };

        /*Exibe o dialog de confirmação de exclusão de registro passando
        as opções como parâmetro, entre outras configurações*/
        int result = JOptionPane.showOptionDialog(
            null,
            "Apagar registro do código XXX?",
            "Confirmação de exclusão",
            JOptionPane.OK_CANCEL_OPTION, 
            JOptionPane.QUESTION_MESSAGE,
            null, 
            options, 
            options[0]
        );
        
        /*Verifica se o usuário clicou no botão OK, ou seja, se ele confirmou a exclusão. A estrutura 
        faz isso verificando se o valor da variável result é igual ao valor da constante OK_OPTION da
        classe JOptionPane, caso seja, retorna true, caso contrário, retorna false*/
        return result == JOptionPane.OK_OPTION;
    }

    public static void registrationError() {
        //Exibe um dialog de erro de cadastro
        CustomDialogs.standardErrorDataManipulation("Erro ao cadastrar registro!");
    }

    public static void updateError() {
        //Exibe um dialog de erro de atualização
        CustomDialogs.standardErrorDataManipulation("Erro ao atualizar registro!");
    }

    public static void standardErrorDataManipulation(String message) {
        //Exibe um dialog de erro de banco de dados
        JOptionPane.showMessageDialog(
            null,
            message +
            "\nVerifique os dados e tente novamente.",
            "Erro",
            JOptionPane.ERROR_MESSAGE
        );
    }

    
}
