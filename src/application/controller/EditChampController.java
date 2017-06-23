package application.controller;

import application.model.Champ;
import application.model.Client;
import application.model.database;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class EditChampController {

    @FXML private VBox vbox;

    @FXML private ComboBox<Integer> etatField;
    @FXML private TextField surfaceField;
    @FXML private TextField adresseField;
    @FXML private TextField coordoneeGPSField;
    @FXML private TextField coordoneeCentreField;
    @FXML private TextField typeField;
    @FXML private ComboBox<Client> clientField;

    private Champ champSelected;
    private champController champController;

    private List<Client> listClients;



    /**
     * boite de dialogue si erreur
     */
    private Stage dialogStage;
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    public void initialize() {
        listClients = new database().recupererClients();
        clientField.getItems().setAll(listClients);
        clientField.setValue(clientField.getItems().get(0));

        etatField.getItems().setAll(0, 1);
        etatField.setValue(etatField.getItems().get(0));
    }

    public void handleOk() {
        if(champSelected != null || rentrerInvalide()) {
            champSelected.setId_ch(clientField.getValue().getId());
            champSelected.setSurf_ch(Integer.parseInt(surfaceField.getText()));
            champSelected.setAdr_ch(adresseField.getText());
            champSelected.setGPS_ch(coordoneeGPSField.getText());
            champSelected.setCult_ch(typeField.getText());
            champSelected.setEtat(etatField.getValue());
            champSelected.setCdn_ch(coordoneeCentreField.getText());

            new database().editChamp(champSelected);
        } else {
            new database().addChamp(clientField.getValue().getId(), Integer.parseInt(surfaceField.getText()), coordoneeCentreField.getText(), adresseField.getText(), typeField.getText(), etatField.getValue(), coordoneeGPSField.getText());
        }

        champController.refreshData();

        ((Stage) vbox.getScene().getWindow()).close();
    }

    public void handleCancel() {
        ((Stage) vbox.getScene().getWindow()).close();
    }

    public void setChampSelected(Champ champ) {
        this.champSelected = champ;

        surfaceField.setText(champ.getSurf_ch() + "");
        adresseField.setText(champ.getAdr_ch());
        coordoneeGPSField.setText(champ.getGPS_ch());
        typeField.setText(champ.getCult_ch());
        etatField.setValue(champ.getEtat());
        coordoneeCentreField.setText(champ.getCdn_ch());

        for(Client client : listClients)
            if(client.equals(champ.getClient()))
                listClients.remove(client);

        clientField.setValue(champ.getClient());
    }

    public void setChampController(champController champController) {
        this.champController = champController;
    }




    private boolean rentrerInvalide() {
        String errorMessage = "";








        if (adresseField.getText() == null || adresseField.getText().length() == 0) {
            errorMessage += "Surface invalide!\n";
        }
        if (coordoneeCentreField.getText() == null || coordoneeCentreField.getText().length() == 0) {
            errorMessage += "Coodonne centre invalide!\n";
        }
        if (coordoneeGPSField.getText() == null || coordoneeGPSField.getText().length() == 0) {
            errorMessage += "Coordonée GPS invalide!\n";
        }

        if (surfaceField.getText() == null || surfaceField.getText().length() == 0) {
            errorMessage += "Surface invalide!\n";
        } else {
            try {
                Integer.parseInt(surfaceField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Rentrez une surface en chiffre ! \n";
            }
        }
        if (typeField.getText() == null || typeField.getText().length() == 0) {
            errorMessage += "Type invalide!\n";
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