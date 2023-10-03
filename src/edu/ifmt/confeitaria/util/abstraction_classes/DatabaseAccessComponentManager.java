package edu.ifmt.confeitaria.util.abstraction_classes;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import edu.ifmt.confeitaria.util.custom_components.ConfirmationDeleteRecordDialog;

public class DatabaseAccessComponentManager<T> {

    enum Operation {
        INSERT,
        UPDATE;
    }

    //ATRIBUTOS
    private SuperController<T> controller;
    private Operation currentOperation;

    //Componentes
    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnPost;
    private JButton btnCancel;
    private JButton btnRefresh;
    private JTable table;
    private DefaultTableModel tableModel;

    //Atributos funcionais
    private Consumer<Object[]> displayDataInFields;

    //CONSTRUCTORS

    //GETTERS E SETTERS
    public void setDisplayDataInFields(Consumer<Object[]> displayDataInFields) {
        this.displayDataInFields = displayDataInFields;
    }

    //MÉTODOS
    public void configureComponents(SuperController<T> controller ,JButton btnInsert, JButton btnUpdate, JButton btnDelete, JButton btnPost, JButton btnCancel, JButton btnRefresh, JTable table) {
        //Setando o controller
        this.controller = controller;
        
        //Setando os componentes
        this.btnInsert = btnInsert;
        this.btnUpdate = btnUpdate;
        this.btnDelete = btnDelete;
        this.btnPost = btnPost;
        this.btnCancel = btnCancel;
        this.btnRefresh = btnRefresh;
        this.table = table;
        this.tableModel = (DefaultTableModel) table.getModel();

        /*Setando os atributos funcionais com funções 'vazias'
        para evitar NullPointerException caso não sejam setados*/
        if(this.displayDataInFields == null) this.displayDataInFields = x -> {};

        //Adicionando os eventos aos componentes
        this.btnInsert.addActionListener((ActionEvent e) -> {
            this.insert();
        });
        this.btnUpdate.addActionListener((ActionEvent e) -> {
            this.update();
        });
        this.btnDelete.addActionListener((ActionEvent e) -> {
            this.delete();
        });
        this.btnPost.addActionListener((ActionEvent e) -> {
            this.post();
        });
        this.btnCancel.addActionListener((ActionEvent e) -> {
            this.cancel();
        });
        this.btnRefresh.addActionListener((ActionEvent e) -> {
            this.refresh();
        });
        this.table.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            this.captureDataFromSelectedTableRow(e);
        });

        /* ---- Setando configurações padrões para os componentes antes de exibir a tela ---- */
        /*Habilitando os botões de edição de registro(como padrão eles devem
        estar habilitados, porém, por garantia, habilitamos eles aqui)*/
        this.enableEditingRecordButtons(true);

        //Desabilitando os botões de confirmação de edição de registro
        this.enableEditConfirmationButtons(false);

        /*Preenchendo a tabela com os dados do banco. Por padrão, ao exibir a interface, a tabela
        é preenchida com todos os dados da sua respectiva tabela no banco de dados, sem filtros*/
        this.displayDataInTable(this.controller.select());
  
        this.setDefaultTableSettings();
    }

    /*  ---- Métodos que serão acionados pelos eventos dos componentes ---- */
    public void insert() {
        /*Setando a operação atual para no momento da confirmação
        da edição, saber qual operação foi realizada pelo usuário*/
        this.currentOperation = Operation.INSERT;

        //Operações visuais
        this.btnUpdate.setEnabled(false);
        this.btnDelete.setEnabled(false);
        this.enableEditConfirmationButtons(true);
        this.operationTableOnInsert();
    }

    public void update() {
        this.enableEditingRecordButtons(false);
        this.enableEditConfirmationButtons(true);
    }

    public void delete() {
        /*Exibe o dialog de confirmação de exclusão de registro por meio do método estático showOptionDialog
        da classe ConfirmationDeleteRecordDialog. O método retorna um boolean que indica se o usuário clicou
        no botão OK ou CANCELAR, caso tenha clicado em OK, o valor retornado é true, caso contrário, é false*/               
        boolean response = ConfirmationDeleteRecordDialog.showDialog();

        /*Estrutura condicional para determinar a ação a ser tomada de acordo com a resposta do usuário*/
        if(response){
            System.out.println("OK"); //Mensagem momentânea de teste
        } else {
            System.out.println("CANCELAR"); //Mensagem momentânea de teste
        }
    }

    public void post() {
        this.enableEditingRecordButtons(true);
        this.enableEditConfirmationButtons(false);

        /*Estrutura condicional para determinar a ação a ser tomada de acordo com a operação atual*/
        if(this.currentOperation == Operation.INSERT) {
            System.out.println("INSERT"); //Mensagem momentânea de teste
        } 
    }
 
    public void cancel() {
        this.enableEditingRecordButtons(true);
        this.enableEditConfirmationButtons(false);
    }

    public void refresh() {
        this.displayDataInTable(this.controller.remakeLastSelect());
    } 

    public void captureDataFromSelectedTableRow(ListSelectionEvent e) {
        // Verifica se uma válida foi selecionada
        if ((!e.getValueIsAdjusting() && e.getFirstIndex() >= 0) && this.table.getSelectedRow() >= 0) {
            /*Captura a linha selecionada e o model da tabela (que é necessário para manipular os dados da tabela)*/
            int selectedRow = this.table.getSelectedRow();

            /*Cria um vetor de objetos para armazenar os dados da linha selecionadada tabela, em seguida, itera sobre
            as colunas da tabela para que ocorra a inserção dos dados da linha selecionada no vetor de objetos citado*/ 
            Object[] dados = new Object[this.tableModel.getColumnCount()];
            for (int i = 0; i < this.tableModel.getColumnCount(); i++) {
                /* Verifica se o valor da célula é nulo, caso seja, o valor atribuído aos dados será uma string
                vazia, caso contrário, o valor atribuído aos dados será o próprio valor da célula da tabela*/
                dados[i] = this.tableModel.getValueAt(selectedRow, i) == null ? "" : this.tableModel.getValueAt(selectedRow, i);
            }

            /*Aciona o método que exibe os dados nos campos de inserção/editação de
            registros da tela, passando como parâmetro os dados da linha selecionada*/
            this.displayDataInFields.accept(dados);   
        }
    }

    /* ------ Métodos/Operações auxiliares ------ */
    public void enableEditingRecordButtons(boolean enable) {
        this.btnInsert.setEnabled(enable);
        this.btnUpdate.setEnabled(enable);
        this.btnDelete.setEnabled(enable);
    }
    
    public void enableEditConfirmationButtons(boolean enable) {
        this.btnPost.setEnabled(enable);
        this.btnCancel.setEnabled(enable);
    }

    public void operationTableOnInsert() {
        /*Quando o insert é acionado, uma linha(a cima da linha que está selecionada) deve ser adicionada na
        tabela e a mesma(nova linha) deve ser agora a linha selecionada. Isso deve ser feito para mostrar ao
        usuário que está sendo inserido um novo registro na tabela(que representa os registros do banco de dados)*/

        // Obtém a linha selecionada
        int selectedRow = this.table.getSelectedRow();

        // Insere uma nova linha acima da linha selecionada por meio do model da tabela
        this.tableModel.insertRow(selectedRow, new Object[this.tableModel.getColumnCount()]);

        // Seleciona a nova linha
        this.table.setRowSelectionInterval(selectedRow, selectedRow);
    }

    /*Método para preencher a tabela com os dados do banco(Separado do evento de clique do botão
    para que possa ser chamado em outras partes do código sem a necessidade de repetir o código)*/
    public void displayDataInTable(List<T> tList) {
        //Limpando a tabela
        this.tableModel.setNumRows(0);

        if(tList != null) {
            //Adicionando os dados na tabela
            for(T tObject : tList) {
                this.tableModel.addRow(this.controller.modelToTableRow(tObject));
            }
        }

        /*É recomendado que as configurações padrões da tabela sejam atualizadas após a inserção  
        de dados, pois as mesmas podem ser perdidas ao atualizar todos os dados da tabela)*/
        this.setDefaultTableSettings();
    }

    /*Método que atualiza a tabela com as configurações padrões*/
    public void setDefaultTableSettings() {
        /*Verifica se a tabela possui linhas antes de 
        ]configurar a sua primeira linha como selecionada*/
        if(this.table.getRowCount() > 0) {
            this.table.setRowSelectionInterval(0, 0);
        }
    }
}
