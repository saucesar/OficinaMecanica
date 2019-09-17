package gui.Cliente;

import fachada.Fachada;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Main;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class ControllerTelaCliente {
    @FXML
    private TextField entradaNome,entradaCpf,entradaTelefone,entradaRua,entradaNumero,entradaBairro,entradaCidade,entradaComplemento;
    @FXML
    private AnchorPane anchorPane;

    public void cadastrarCliente(){
        try {
            String nome = entradaNome.getText();
            String cpf = entradaCpf.getText();
            String telefone = entradaTelefone.getText();

            String rua = entradaRua.getText();
            String numero = entradaNumero.getText();
            String bairro = entradaBairro.getText();
            String cidade  = entradaCidade.getText();
            String complemento = entradaComplemento.getText();

            Fachada.getInstance().salvarCliente(nome,cpf,telefone,rua,numero,bairro,cidade,complemento);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("Cliente Salvo Com Sucesso!!!");
            alert.showAndWait();

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO!!!");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        finally { fecharJanela();}
    }

    public void editarCliente() throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(
                this.getClass().getClassLoader().getResource("gui/Cliente/telaCadastroCliente.fxml")));
        Main.novaJanela(parent);
    }

    public void clikVoltar(){
        try{
            fecharJanela();
            Main.setJanela(FXMLLoader.load(
                    Objects.requireNonNull(getClass().getClassLoader().getResource("gui/MenuPrincipal/menuPrincipal.fxml"))));
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }

    public void fecharJanela(){
        Stage stage = (Stage) this.anchorPane.getScene().getWindow();
        stage.close();
    }
}
