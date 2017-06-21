package application.controller;

import application.model.Client;
import application.model.Machine;
import application.model.database;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;


public class EditPersonneController {

    @FXML private VBox vbox;

    @FXML private TextField prenomField;
    @FXML private TextField nomField;
    @FXML private TextField telField;
    @FXML private TextField adresseField;
    @FXML private TextField typeField;
    @FXML private ComboBox<Client> clientField;

    private Client clientSelected;
    private personneController clientController;


    private List<Client> listClients;

    public void initialize() {
        listClients = new database().recupererClients();
        clientField.getItems().setAll(listClients);
        clientField.setValue(clientField.getItems().get(0));
    }

    public void handleOk() {
        if(clientSelected != null) {
            clientSelected.setId (clientField.getValue().getId());
            clientSelected.setPrenom(prenomField.getText());
            clientSelected.setNom(nomField.getText());
            clientSelected.setTelephone(telField.getText());
            clientSelected.setAdresse(adresseField.getText());
            clientSelected.setTypeCl(typeField.getText());
            new database().editClient(clientSelected);
        } else {
            new database().addClient( clientField.getValue().getId(), prenomField.getText(), nomField.getText(), Integer.parseInt(telField.getText()), adresseField.getText(), typeField.getText());

        }

        personneController.refreshData();

        ((Stage) vbox.getScene().getWindow()).close();

    }


    public void handleCancel() {

        ((Stage) vbox.getScene().getWindow()).close();
    }

    public void setMachineSelected(Client client) {
        this.clientSelected = client;

        prenomField.setText(client.getPrenom());
        nomField.setText(client.getNom());
        telField.setText(client.getTelephone());
        adresseField.setText(client.getAdresse());
        typeField.setText(client.getTypeCl());
    }

    public void setClientController(personneController personneController) {
        this.personneController = personneController;
    }


    public void setClientSelected(Client client){}
}
