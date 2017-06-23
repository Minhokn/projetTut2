package application.controller;

import application.model.Client;
import application.model.Machine;
import application.model.database;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    @FXML private ComboBox<String> typeField;


    private Client clientSelected;
    private personneController personneController;

    private List<Client> listClients;

    /**
     * boite de dialogue si erreur
     */
    private Stage dialogStage;
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Initialisation
     */
    public void initialize() {
        typeField.getItems().setAll("Agriculteur", "Coop");

    }

    /**
     * Si on appui sur le bouton ok on ajoute le client ssi tous les champs sont rentrés sauf prenom
     */
    public void handleOk() {
        if(clientSelected != null || rentrerInvalide()) {
            clientSelected.setPrenom(prenomField.getText());
            clientSelected.setNom(nomField.getText());
            clientSelected.setTelephone(telField.getText());
            clientSelected.setAdresse(adresseField.getText());
            clientSelected.setTypeCl(typeField.getValue());

            new database().editClient(clientSelected);
        } else {
            new database().addClient(prenomField.getText(), nomField.getText(), telField.getText(), adresseField.getText(), typeField.getValue());
        }

        personneController.refreshData();

        ((Stage) vbox.getScene().getWindow()).close();
    }

    /**
     * Boutton annulé
     */
    public void handleCancel() {
        ((Stage) vbox.getScene().getWindow()).close();
    }

    /**
     * Selection d'un client
     * @param client
     */
    public void setClientSelected(Client client) {
        this.clientSelected = client;

        prenomField.setText(client.getPrenom());
        nomField.setText(client.getNom());
        telField.setText(client.getTelephone());
        adresseField.setText(client.getAdresse());
        typeField.setValue(client.getTypeCl());
    }

    public void setClientController(personneController personneController) {
        this.personneController = personneController;
    }


    /**
     * Verification des champs
     * @return
     */
    private boolean rentrerInvalide() {
        String errorMessage = "";

        if (nomField.getText() == null || nomField.getText().length() == 0) {
            errorMessage += "Prenom invalide!\n";
        }
        if (telField.getText() == null || telField.getText().length() == 0) {
            errorMessage += "telephone invalide!\n";
        }
        if (adresseField.getText() == null || adresseField.getText().length() == 0) {
            errorMessage += "Adresse invalide!\n";
        }

        if (telField.getText() == null || telField.getText().length() == 0) {
            errorMessage += "Telephone invalide!\n";
        } else {
            try {
                Integer.parseInt(telField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Rentrez le telephone en chiffre ! \n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Erreur de renseignement");
            alert.setHeaderText("Veuillez corriger les errreurs");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }



}
