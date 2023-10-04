package edu.ifmt.confeitaria.util.abstraction_classes;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import edu.ifmt.confeitaria.util.custom_components.ConfirmationDeleteRecordDialog;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class DatabaseAccessComponentManager<T> {

    public enum Operation {
        INSERT,
        UPDATE,
        NONE;
    }

    //ATRIBUTOS
    private BehaviorSubject<List<T>> temporaryTDataList;
    private BehaviorSubject<T> tSelectedRecord;
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
    private Function<T, Object[]> modelToTableRow;
    private Consumer<T> modelToFields;
    private Runnable clearFields;

    //CONSTRUCTORS

    //GETTERS, SETTERS E OBSERVABLES
    public void updateTemporaryTDataList(List<T> tDataList) {
        if(tDataList != null){
            this.temporaryTDataList.onNext(tDataList);
        }
    }

    public void updateSelectedRecord(int recordIndex) {
        if(this.temporaryTDataList.getValue() != null && recordIndex >= 0 && recordIndex < this.temporaryTDataList.getValue().size()) {
            this.tSelectedRecord.onNext(this.temporaryTDataList.getValue().get(recordIndex));
        }   
    }

    public void setModelToTableRow(Function<T, Object[]> modelToTableRow) {
        this.modelToTableRow = modelToTableRow;
    }

    public void setModelToFields(Consumer<T> modelToFields) {
        this.modelToFields = modelToFields;
    }

    public void setClearFields(Runnable clearFields) {
        this.clearFields = clearFields;
    }

    //MÉTODOS
    public void configureComponents(SuperController<T> controller ,JButton btnInsert, JButton btnUpdate, JButton btnDelete, JButton btnPost, JButton btnCancel, JButton btnRefresh, JTable table) {
        //Criando os observables
        this.temporaryTDataList = BehaviorSubject.create();
        this.tSelectedRecord = BehaviorSubject.create();

        //Setando os atributos
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
        if(this.modelToTableRow == null) this.modelToTableRow = x -> null;
        if(this.modelToFields == null) this.modelToFields = x -> {};
        if(this.clearFields == null) this.clearFields = () -> {};

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
            this.informRecordIndexFromSelectedTableRow(e);
        });

        //Setando as configurações padrões do manager
        this.resetManagerDefaultSettings();

        /*Conecta o observable à lista de usuários. Toda vez
        que a lista for atualizada, a tabela será atualizada*/
        this.temporaryTDataList.subscribe(this::displayDataInTable);

        /*Conecta o observable ao registro selecionado. Toda vez que o registro
        selecionado for atualizado, os novos dados serão exibidos nos campos*/
        this.tSelectedRecord.subscribe(this::displayDataInFields);

        /*Atualiza a lista de dados temporária por meio do método
        select do controller, realizando uma consulta sem filtros*/
        this.updateTemporaryTDataList(this.controller.select());
        
        //Atualiza as configurações padrões da tabela
        this.setDefaultTableSettings();
    }

    /*  ---- Métodos que serão acionados pelos eventos dos componentes ---- */
    private void insert() {
        //As ações são realizadas apenas se não houver nenhuma outra operação em andamento
        if(this.currentOperation == Operation.NONE) {
            this.currentOperation = Operation.INSERT;

            //Operações visuais
            this.btnUpdate.setEnabled(false);
            this.btnDelete.setEnabled(false);
            this.enableEditConfirmationButtons(true);
            this.operationDataDisplayComponentsOnInsert();
        }   
    }

    private void update() {
        this.enableEditingRecordButtons(false);
        this.enableEditConfirmationButtons(true);
    }

    private void delete() {
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

    private void post() {
        try{
            /*Estrutura condicional para determinar a ação a ser tomada de acordo com a operação atual*/
            if(this.currentOperation == Operation.INSERT) {
                System.out.println("INSERT REALIZADO"); //Mensagem momentânea de teste
            }

            this.resetManagerDefaultSettings();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
 
    private void cancel() {
        try{
            /*Estrutura condicional para determinar a ação a ser tomada de acordo com a operação atual*/
            if(this.currentOperation == Operation.INSERT) {
                System.out.println("INSERT CANCELADO"); //Mensagem momentânea de teste
            }

            this.resetManagerDefaultSettings();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void refresh() {  
        this.updateTemporaryTDataList(this.controller.remakeLastSelect());
        this.resetManagerDefaultSettings();
    } 

    private void informRecordIndexFromSelectedTableRow(ListSelectionEvent e) {
        // Verifica se uma válida foi selecionada
        if ((!e.getValueIsAdjusting() && e.getFirstIndex() >= 0) && this.table.getSelectedRow() >= 0) {
            //Captura a linha selecionada
            int selectedRow = this.table.getSelectedRow();

            //Atualiza o registro selecionado
            this.updateSelectedRecord(selectedRow);
        }
    }

    /* ------ Métodos/Operações auxiliares ------ */
    private void enableEditingRecordButtons(boolean enable) {
        this.btnInsert.setEnabled(enable);
        this.btnUpdate.setEnabled(enable);
        this.btnDelete.setEnabled(enable);
    }
    
    private void enableEditConfirmationButtons(boolean enable) {
        this.btnPost.setEnabled(enable);
        this.btnCancel.setEnabled(enable);
    }

    private void resetManagerDefaultSettings() {
        this.currentOperation = Operation.NONE;
        this.enableEditingRecordButtons(true);
        this.enableEditConfirmationButtons(false);
    }

    /*Método para preencher a tabela com os dados do banco(Separado do evento de clique do botão
    para que possa ser chamado em outras partes do código sem a necessidade de repetir o código)*/
    private void displayDataInTable(List<T> tList) {
        //Limpando a tabela
        this.tableModel.setNumRows(0);

        if(tList != null) {
            //Adicionando os dados na tabela
            for(T tObject : tList) {
                try {
                    this.tableModel.addRow(this.modelToTableRow.apply(tObject));
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }
        /*É recomendado que as configurações padrões da tabela sejam atualizadas após a inserção  
        de dados, pois as mesmas podem ser perdidas ao atualizar todos os dados da tabela)*/
        this.setDefaultTableSettings();
    }

    //Método para exibir os dados do registro selecionado nos campos
    private void displayDataInFields(T tSelectedRecord) {
        this.modelToFields.accept(tSelectedRecord);
    }
       
    /*Método que atualiza a tabela com as configurações padrões*/
    private void setDefaultTableSettings() {
        /*Verifica se a tabela possui linhas antes de 
        ]configurar a sua primeira linha como selecionada*/
        if(this.table.getRowCount() > 0) {
            this.table.setRowSelectionInterval(0, 0);
        }
    }

    private void operationDataDisplayComponentsOnInsert() {
        /*Quando o insert é acionado, uma linha(a cima da linha que está selecionada) deve ser adicionada na tabela e a
        mesma(nova linha) deve ser agora a linha selecionada, bem como os campos devem ser limpos. Isso deve ser feito para
        mostrar ao usuário que está sendo inserido um novo registro na tabela(que representa os registros do banco de dados)*/

        /*Obs: Essas operações na tabela e nos campos não tem ligação direta com a manipulação dos dados do 
        banco, nem com a lista de dados obtidas do mesmo(que é usada para exibir as informações nos componentes 
        necessários) trata-se apenas de uma representação visual. Ou seja, ao inserir uma linha na tabela, não
        significa que um novo registro foi inserido no banco de dados nem na lista de dados obtidas dele.*/

        // Obtém a linha selecionada
        int selectedRow = this.table.getSelectedRow();

        // Insere uma nova linha acima da linha selecionada por meio do model da tabela
        this.tableModel.insertRow(selectedRow, new Object[this.tableModel.getColumnCount()]);

        // Seleciona a nova linha
        this.table.setRowSelectionInterval(selectedRow, selectedRow);

        //Limpa os campos
        this.clearFields.run();
    }
}
