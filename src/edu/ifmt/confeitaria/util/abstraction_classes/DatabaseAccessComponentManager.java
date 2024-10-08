package edu.ifmt.confeitaria.util.abstraction_classes;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import edu.ifmt.confeitaria.util.custom_components.CustomDialogs;
import edu.ifmt.confeitaria.util.views.ViewUtils;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class DatabaseAccessComponentManager<T extends SuperModel> {

    public enum Operation {
        INSERT,
        UPDATE,
        NONE;
    }

    //ATRIBUTOS
    private Class<T> modelClass;
    private SuperController<T> controller;
    private SuperService<T> service;
    private BehaviorSubject<List<T>> temporaryTDataList = BehaviorSubject.create();
    private BehaviorSubject<T> tSelectedRecord = BehaviorSubject.create();
    private BehaviorSubject<Integer> selectedRecordIndex = BehaviorSubject.create();
    private Operation currentOperation;
    private boolean activateUpdateWhenFieldsChange;
    private boolean activateInsertWhenFieldsChange;
    private boolean keepIndexSelectedRecord;
    private boolean insertOnTextChange;

    //Componentes
    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnPost;
    private JButton btnCancel;
    private JButton btnRefresh;
    private JTable table;
    private DefaultTableModel tableModel;
    //Componente setado separadamente(fora do método configureComponents)
    private List<Component> fields;

    //GETTERS, SETTERS E OBSERVABLES
    public void subscribeTemporaryTDataList(Consumer<List<T>> consumer) {
        this.temporaryTDataList.subscribe(consumer);
    }

    public void subscribeTSelectedRecord(Consumer<T> consumer) {
        this.tSelectedRecord.subscribe(consumer);
    }

    public BehaviorSubject<List<T>> getTemporaryTDataList() {
        return temporaryTDataList;
    }

    private void updateTemporaryTDataList(List<T> tDataList) {
        /*Verifica se a lista de dados temporária está vazia, se estiver, 
        adiciona um registro em branco na lista para evitar bugs*/
        if(tDataList != null){
            this.btnUpdate.setEnabled(true);
            this.btnDelete.setEnabled(true);
            this.insertOnTextChange = false;
            if(tDataList.isEmpty()) {
                try {
                    tDataList.add((T) this.modelClass.getConstructor().newInstance());
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                    e.printStackTrace();
                }
            }
            this.temporaryTDataList.onNext(tDataList);
            if(this.temporaryTDataListIsEmpty()) {
                this.btnUpdate.setEnabled(false);
                this.btnDelete.setEnabled(false);
                this.insertOnTextChange = true;
            }
        }
    }

    private void updateSelectedRecordIndex(int recordIndex) {
        /* O atributo "activateUpdateWhenFieldsChange" é setado como false para que o método "update" não seja acionado quando
        o índice do registro selecionado for atualizado, pois isso causaria um loop infinito, pois o método "update" atualiza o
        índice do registro selecionado, e isso acionaria o método "update" novamente, e assim por diante. Logo, desligamos essa
        funcionabilidade dos fields temporariamente para que não haja esse probelma. Após o índice do registro selecionado ser
        atualizado, o atributo "activateUpdateWhenFieldsChange" é setado como true novamente, para que o método "update" volte
        a ser acionado quando os fields forem atualizados. O mesmo acontece com o atributo "activateInsertWhenFieldsChange"*/
        this.activateUpdateWhenFieldsChange = false;
        this.activateInsertWhenFieldsChange = false;
        if(this.temporaryTDataList.getValue() != null && recordIndex >= 0 && recordIndex < this.temporaryTDataList.getValue().size()) {
            this.selectedRecordIndex.onNext(recordIndex);
        } 
        this.activateUpdateWhenFieldsChange = true;
        this.activateInsertWhenFieldsChange = true;
    }

    /*O método "updateTemporaryTDataList" é privado, pois a atualização da lista de dados não deve ser feita
    diretamente por meio de classes externas, pois isso poderia causar comportamentos inesperados. Logo, deve
    haver outro método que seja responsável por tratar a atualização da lista de dados vindo de classes externas*/
    public void setTemporaryTDataList(List<T> tDataList) {
        /*Caso houver uma operação em andamento, a mesma será tratada como cancelada 
        se a lista de dados for atualizada por meio de uma classe externa*/
        this.cancel();
        this.updateTemporaryTDataList(tDataList);
    }

    //Componente setado separadamente(fora do método configureComponents)
    public void setFields(List<Component> fields) {
        this.setDefaultFieldSettings(fields);
        this.fields = fields;
    }

    public BehaviorSubject<T> getTSelectedRecord() {
        return tSelectedRecord;
    }

    public Operation getCurrentOperation() {
        return currentOperation;
    }

    //MÉTODOS
    public void configureComponents(Class<T> modelClass, SuperController<T> controller, SuperService<T> service,
                                    JButton btnInsert, JButton btnUpdate, JButton btnDelete, JButton btnPost,
                                    JButton btnCancel, JButton btnRefresh, JTable table) {
        //Setando os atributos
        this.modelClass = modelClass;
        this.controller = controller;
        this.service = (service == null) ? new SuperService<T>() {
                @Override
                public List<T> selectAll() {
                    return null;
                }

                @Override
                public List<T> redoLastPartialSearch() {
                    return null;
                }

                @Override
                public boolean insert(T tObject) {
                    return false;
                }

                @Override
                public boolean update(T tObject, T tObjectOriginal) {
                    return false;
                }

                @Override
                public boolean delete(T tObject) {
                    return false;
                }
            } : service;
        
        //Setando os componentes
        this.btnInsert = btnInsert;
        this.btnUpdate = btnUpdate;
        this.btnDelete = btnDelete;
        this.btnPost = btnPost;
        this.btnCancel = btnCancel;
        this.btnRefresh = btnRefresh;
        this.table = table;
        this.tableModel = (DefaultTableModel) table.getModel();

        //Criando os observables
        // this.temporaryTDataList = BehaviorSubject.create();
        // this.tSelectedRecord = BehaviorSubject.create();
        // this.selectedRecordIndex = BehaviorSubject.create();

        //Setando os valores iniciais dos atributos necessários
        this.activateUpdateWhenFieldsChange = true;
        this.activateInsertWhenFieldsChange = true;
        this.keepIndexSelectedRecord = false;

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

        /*Conecta o observable ao índice do registro selecionado. Toda vez que o índice
        do registro selecionado for atualizado, o registro selecionado será atualizado*/
        this.selectedRecordIndex.subscribe((index) -> {
            this.tSelectedRecord.onNext(this.temporaryTDataList.getValue().get(this.selectedRecordIndex.getValue()));

        });

        /*Atualiza a lista de dados temporária por meio do método
        select do controller, realizando uma consulta sem filtros*/
        this.updateTemporaryTDataList(this.service.selectAll());
        
        //Atualiza as configurações padrões da tabela
        this.setDefaultTableSettings();
    }

    /*  ---- Métodos que serão acionados pelos eventos dos componentes ---- */
    private void insert() {
        /*As ações são realizadas apenas se não houver nenhuma outra operação em andamento
        e se a opção "ativar insert quando os campos forem alterados" estiver ativada*/
        if(this.currentOperation == Operation.NONE && this.activateInsertWhenFieldsChange) {
            this.currentOperation = Operation.INSERT;

            if(!this.temporaryTDataListIsEmpty()) {
                this.addNewRecordTemporaryDataList();
            }
            //Operações visuais
            this.table.setEnabled(false);
            this.enableEditingRecordButtons(false);
            this.enableEditConfirmationButtons(true);  
        }   
    }

    private void update() {
        /*As ações são realizadas apenas se não houver nenhuma outra operação em andamento
        e se a opção "ativar update quando os campos forem alterados" estiver ativada*/
        if(this.currentOperation == Operation.NONE && this.activateUpdateWhenFieldsChange) {    
            this.currentOperation = Operation.UPDATE;
 
            /*Verifica se os campos foram setados para serem gerenciados pelo manager antes acionar o método de atualização dos mesmos. Obs: Forçar 
            atualização dos campos, como mencionado no comentário abaixo, é necessário para resolver conflitos de configurações desses campos.*/
            if(this.fields == null || this.fields.size() == 0){
                /*Força que os campos sejam atualizados com os dados do registro selecionado. Obs: Há um observable que é 
                responsável por isso, porém, nesse caso, devido a conflitos de configurações, é necessário forçar a atualização*/
                this.displayDataInFields(this.tSelectedRecord.getValue());
            }
            //Operações visuais
            this.table.setEnabled(false);
            this.enableEditingRecordButtons(false);
            this.enableEditConfirmationButtons(true);
        }
    }

    private void delete() {
        /*Exibe o dialog de confirmação de exclusão de registro por meio do método estático correspondente
        da classe CustomDialogs. O método retorna um boolean que indica se o usuário clicou no botão OK ou
        ou CANCELAR, caso tenha clicado em OK, o valor retornado é true, caso contrário, é false*/               
        boolean userResponse = CustomDialogs.ConfirmationDeleteRecord(this.tSelectedRecord.getValue().getID());

        //Caso a resposta do usuário seja positiva, o registro será excluído
        if(userResponse){
            boolean serviceResponse = this.service.delete(this.tSelectedRecord.getValue());
            if(serviceResponse) {
                /*Solicita para que o indice do registro selecionado seja mantido antes de atualizar a lista de dados 
                temporária, pois a mesma será atualizada e o índice será o primeiro se isso não for solicitado*/
                this.keepIndexSelectedRecord = true;
                
                //Atualiza a lista de dados temporária para as mudanças serem refletidas nos componentes visuais
                this.temporaryTDataList.getValue().remove(this.tSelectedRecord.getValue());
                
                /*Em caso do registro excluído ser o último da lista, o índice do registro selecionado deve ser atualizado
                para o registro que está acima do registro excluído, pois o indice anterior não existe mais*/
                if(this.selectedRecordIndex.getValue().equals(this.temporaryTDataList.getValue().size()) && this.selectedRecordIndex.getValue() > 0) {
                    this.selectedRecordIndex.onNext(this.selectedRecordIndex.getValue() - 1);
                }
                /*Força a atualização da lista pois o observable não notifica alterações quando apenas itens da lista são alterados*/
                this.updateTemporaryTDataList(this.temporaryTDataList.getValue());
                if(!this.temporaryTDataListIsEmpty()) this.resetManagerDefaultSettings();
            } else {
                //Exibe um dialog de erro de exclusão
                CustomDialogs.deleteError();
            }
        }
    }

    private void post() {
        //Captura os dados dos campos já em formato de objeto
        T tObject = this.controller.fieldsToModel();

        /*Estrutura condicional para determinar a ação a ser tomada de acordo com a operação atual*/
        if(this.currentOperation == Operation.INSERT) {
            // Solita a inserção do objeto no BD por meio da controller, armazenando a resposta de sucesso ou não da operação
            boolean response = this.service.insert(tObject);

            if(response) {
                this.resetManagerDefaultSettings();
                /*Solicita para que o indice do registro selecionado seja mantido antes de atualizar a lista de dados 
                temporária, pois a mesma será atualizada e o índice será o primeiro se isso não for solicitado*/
                this.keepIndexSelectedRecord = true;

                //Atualiza a lista de dados temporária para as mudanças serem refletidas nos componentes visuais
                this.temporaryTDataList.getValue().set(this.selectedRecordIndex.getValue(), tObject);

                /*Força a atualização da lista pois o observable não notifica alterações quando apenas itens da lista são alterados*/
                this.updateTemporaryTDataList(this.temporaryTDataList.getValue());
            } else {
                //Exibe um dialog de erro de cadastro
                CustomDialogs.registrationError();
            }
        } else if(this.currentOperation == Operation.UPDATE) {
            if(tObject.getID() == null) {
                tObject.setID(this.tSelectedRecord.getValue().getID());
            }
            // Solita a atualização do objeto no BD por meio da controller, armazenando a resposta de sucesso ou não da operação
            boolean response = this.service.update(tObject, this.tSelectedRecord.getValue());

             if(response) {
                this.resetManagerDefaultSettings();
                /*Solicita para que o indice do registro selecionado seja mantido antes de atualizar a lista de dados 
                temporária, pois a mesma será atualizada e o índice será o primeiro se isso não for solicitado*/
                this.keepIndexSelectedRecord = true;

                //Atualiza a lista de dados temporária para as mudanças serem refletidas nos componentes visuais
                this.temporaryTDataList.getValue().set(this.selectedRecordIndex.getValue(), tObject);

                /*Força a atualização da lista pois o observable não notifica alterações quando apenas itens da lista são alterados*/
                this.updateTemporaryTDataList(this.temporaryTDataList.getValue());
            } else {
                //Exibe um dialog de erro de atualização 
                CustomDialogs.updateError();
            }
        }
    }
 
    public void cancel() {
        /*Estrutura condicional para determinar a ação a ser tomada de acordo com a operação atual*/
        if(this.currentOperation == Operation.INSERT) {
            this.resetManagerDefaultSettings();
            /*Solicita para que o indice do registro selecionado seja mantido antes de atualizar a lista de dados 
            temporária, pois a mesma será atualizada e o índice será o primeiro se isso não for solicitado*/
            this.keepIndexSelectedRecord = true;

            //Desativa a funcionalidade antes de atualizar os campos para evitar um loop infinito
            this.activateInsertWhenFieldsChange = false;
 
            /*Caso o usuário cancele a inserção do registro, o registro em branco que foi adicionado na 
            lista de dados temporária deve ser removido, pois o mesmo não será inserido no banco de dados*/
            this.temporaryTDataList.getValue().remove(this.tSelectedRecord.getValue());

            /*Atualiza a lista de dados temporária diretamente, pois o observable 
            não notifica a alteração quando apenas itens da lista são alterados*/
            this.updateTemporaryTDataList(this.temporaryTDataList.getValue());
            
            //Ativa a funcionalidade novamente
            this.activateInsertWhenFieldsChange = true;
        } else if(this.currentOperation == Operation.UPDATE) {
            this.resetManagerDefaultSettings();
            //Desativa a funcionalidade antes de atualizar os campos para evitar um loop infinito
            this.activateUpdateWhenFieldsChange = false;

            /*Caso o usuário cancele a edição do registro, os campos devem ser atualizados manualmente
            com os dados originais do registro que havia sido selecionado para atualização. Como quem 
            notifica a atualização dos campos é um observable, e os dados da mesma não foram alterados
            de fato, apenas copiados para os campos, então é necessário forçar a atualização dos campos*/
            this.displayDataInFields(this.tSelectedRecord.getValue());

            //Ativa a funcionalidade novamente
            this.activateUpdateWhenFieldsChange = true;
        }
    }

    public void refresh() {  
        this.resetManagerDefaultSettings();
        this.updateTemporaryTDataList(this.service.redoLastPartialSearch());
    } 

    private void informRecordIndexFromSelectedTableRow(ListSelectionEvent e) {
        // Verifica se uma válida foi selecionada
        if ((!e.getValueIsAdjusting() && e.getFirstIndex() >= 0) && this.table.getSelectedRow() >= 0) {
            //Captura a linha selecionada
            int selectedRow = this.table.getSelectedRow();

            //Atualiza o índice do registro selecionado
            this.updateSelectedRecordIndex(selectedRow);
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
        this.insertOnTextChange = false;
        this.table.setEnabled(true);
        this.enableEditingRecordButtons(true);
        this.enableEditConfirmationButtons(false);
    }

     /*Método que atualiza a tabela com as suas configurações padrões*/
    private void setDefaultTableSettings() {
         if(this.keepIndexSelectedRecord) {
            this.table.setRowSelectionInterval(this.selectedRecordIndex.getValue(), this.selectedRecordIndex.getValue());
            this.keepIndexSelectedRecord = false;
        }
        /*Verfica se a operação atual é de inserção, se for, define a linha selecionada da tabela com valor igual ao índice
        do registro selecionado, pois quando o insert é acionado, toda a tabela é atualizada, e isso faz com que não haja
        mais uma linha selecionada, então é ecessário selecionar a linha que estava selecionada antes da atualização*/
        else if(this.currentOperation == Operation.INSERT) {
            this.table.setRowSelectionInterval(this.selectedRecordIndex.getValue(), this.selectedRecordIndex.getValue());
        }
        //Verifica se há registros na tabela, se houver, define a primeira linha da tabela como selecionada(configuração padrão)
        else  if(this.table.getRowCount() > 0) {
            this.table.setRowSelectionInterval(0, 0);
            //Atualiza a barra de rolagem para que a primeira linha da tabela fique visível
            this.table.scrollRectToVisible(this.table.getCellRect(0, 0, true)); 
        }
    }

    /*Método para preencher a tabela com os dados do banco(Separado do evento de clique do botão
    para que possa ser chamado em outras partes do código sem a necessidade de repetir o código)*/
    private void displayDataInTable(List<T> tList) {
        //Limpando a tabela
        this.tableModel.setNumRows(0);

        if(tList != null && tList.size() > 0) {
            //Adicionando os dados na tabela
            for(T tObject : tList) {
                try {
                    this.tableModel.addRow(this.controller.modelToTableRow(tObject));
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
        /*Os campos só exibirão os dados se a operação atual for de atualização ou se os mesmos forem setados
        para serem gerenciados pelo manager (que configurará os campos adequadamente para que possam
        exibir os dados do registro selecionado fora de uma operação de atualização sem causar erros)*/
        if((this.currentOperation == Operation.UPDATE || this.fields != null && this.fields.size() > 0)){
            this.controller.modelToFields(tSelectedRecord);
        } else if(this.currentOperation == Operation.NONE && (this.fields == null || this.fields.size() == 0)) {
            /*Caso a operação atual for NONE e se os campos que exibem os dados não foram setados para serem gerenciados
            pelo manager, esse método garantirá que os campos não exibam nenhum dado, pois isso poderia causar erros.
            Essa ação é realizada passando um objeto vazio para o método que atualiza os campos*/
            try {
                //Desligando as funcionalidades para evitar um loop infinito
                this.activateUpdateWhenFieldsChange = false;
                this.activateInsertWhenFieldsChange = false;

                T tObject = (T) this.modelClass.getConstructor().newInstance();
                this.controller.modelToFields(tObject);

                //Ligando as funcionalidades novamente
                this.activateUpdateWhenFieldsChange = true;
                this.activateInsertWhenFieldsChange = true;
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                e.printStackTrace();
            }
        }
    }

    private void addNewRecordTemporaryDataList() {
        /*Quando o insert é acionado, um novo registro, a cima do registro selecionado, deve ser adicionado na lista de dados 
        temporária, logo, os compoentes visuais que estão consumindo os dados dessa lista, serão atualizados e exibirão o novo 
        registro em branco, simulando a inserção de um novo registro no BD. Ou seja, toda essa operação é apenas uma prévia da  
        inserção de um novo registro no banco de dados, que só será realizada de fato quando o usuário clicar no botão POST.*/
        try {
            T tObject = (T) this.modelClass.getConstructor().newInstance();
            this.temporaryTDataList.getValue().add(this.selectedRecordIndex.getValue(), tObject);
            // tDataList.add(this.selectedRecordIndex.getValue(), tObject);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException | NoSuchMethodException e) {
            this.currentOperation = Operation.NONE;
            e.printStackTrace(); 
        }
        
        /*Atualiza a lista de dados temporária diretamente, pois o observable 
        não notifica a alteração quando apenas itens da lista são alterados*/
        this.updateTemporaryTDataList(this.temporaryTDataList.getValue());
    }

    private void setDefaultFieldSettings(List<Component> fields) {
        /*Adiciona os eventos aos campos para que os mesmos possam acionar
        o método "update" quando os dados dos campos forem alterados.*/
        fields.forEach( field -> {
            if(field instanceof JDateChooser){
                ((JDateChooser) field).addPropertyChangeListener((PropertyChangeEvent evt) -> {
                    if(evt.getPropertyName().equals("date")){
                        this.actionOnFieldChange();
                    }
                });
            } else if(field instanceof JTextField){
                ViewUtils.addTextChangeListeners((JTextField) field, this::actionOnFieldChange);
            } else if(field instanceof JToggleButton){
                ((JToggleButton) field).addItemListener((ItemEvent evt) -> {
                    this.actionOnFieldChange();
                });
            } else if(field instanceof JComboBox){
                ((JComboBox<?>) field).addItemListener((ItemEvent evt) -> {
                    this.actionOnFieldChange();
                });
            }
        });
    }

    private void actionOnFieldChange() {
        if(this.insertOnTextChange) {
            this.insert();
        } else {
            this.update();
        }
    }

    private boolean temporaryTDataListIsEmpty() {
        return (this.temporaryTDataList.getValue() != null && this.temporaryTDataList.getValue().size() == 1
                && this.temporaryTDataList.getValue().get(0).getID() == null) ? true : false;
    }
}
