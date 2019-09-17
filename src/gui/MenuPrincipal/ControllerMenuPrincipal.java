package gui.MenuPrincipal;

import fachada.Fachada;
import gui.Cliente.ControllerTelaCliente;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Main;
import negocio.entidades.Cliente;
import negocio.entidades.Endereco;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ControllerMenuPrincipal {
    @FXML
    private TableView<ClienteTab> tabelaClientes;
    @FXML
    private TableColumn<ClienteTab,String> colunaCpf,colunaNome,colunaTelefone,colunaEndereco;
    @FXML
    private AnchorPane anchorMenu;

    public void clikAbaClientes(){
        try{
            colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
            colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
            colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
            this.tabelaClientes.setItems(getClientes());
        }
        catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    private ObservableList<ClienteTab> getClientes() throws SQLException {
        ObservableList<ClienteTab> clientes = FXCollections.observableArrayList();
        for(Cliente c:Fachada.getInstance().listarClientes()){
            clientes.add(new ClienteTab(c.getCpf(),c.getNome(),c.getTelefone(),c.getEndereco()));
        }
        return clientes;
    }

    public void clikEditar() throws SQLException, IOException {
        ControllerTelaCliente c = new ControllerTelaCliente();
        c.editarCliente();
    }

    public void clikExcluir(){
        Parent parent = null;
        try{
            Fachada.getInstance().deletarCliente(tabelaClientes.getSelectionModel().getSelectedItem().getCpf());
            parent = FXMLLoader.load(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("gui/MenuPrincipal/menuPrincipal.fxml")));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso!!!");
            alert.setHeaderText(null);
            alert.setContentText("Cliente Excluido!!!");
            alert.showAndWait();
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }finally {
            Main.setJanela(parent);
        }
    }

    public void clikNovo(){
        Parent parent = null;
        try{
            parent = FXMLLoader.load(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("gui/Cliente/telaCadastroCliente.fxml")));
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }finally {
            Main.novaJanela(parent);
        }
    }

    public static class ClienteTab {
        private final SimpleStringProperty cpf;
        private final SimpleStringProperty nome;
        private final SimpleStringProperty telefone;
        private final SimpleStringProperty endereco;

        ClienteTab(String cpf, String nome, String telefone, Endereco endereco) {
            this.cpf = new SimpleStringProperty(cpf);
            this.nome = new SimpleStringProperty(nome);
            this.telefone = new SimpleStringProperty(telefone);
            this.endereco = new SimpleStringProperty(endereco.toString());
        }

        public String getCpf() { return cpf.get(); }
        public SimpleStringProperty cpfProperty() { return cpf; }
        public void setCpf(String cpf) { this.cpf.set(cpf); }

        public String getNome() { return nome.get(); }
        public SimpleStringProperty nomeProperty() { return nome; }
        public void setNome(String nome) { this.nome.set(nome); }

        public String getTelefone() { return telefone.get(); }
        public SimpleStringProperty telefoneProperty() { return telefone; }
        public void setTelefone(String telefone) { this.telefone.set(telefone); }

        public String getEndereco() { return endereco.get(); }
        public SimpleStringProperty enderecoProperty() { return endereco; }
        public void setEndereco(String endereco) { this.endereco.set(endereco); }
    }

    public void fecharJanela(){
        Stage stage = (Stage) this.anchorMenu.getScene().getWindow();
        stage.close();
    }
}
