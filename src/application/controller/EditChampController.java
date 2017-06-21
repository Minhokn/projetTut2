package application.controller;

import application.model.Champ;
import application.model.Client;
import application.model.database;
import javafx.fxml.FXML;
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

    public void initialize() {
        listClients = new database().recupererClients();
        clientField.getItems().setAll(listClients);
        clientField.setValue(clientField.getItems().get(0));

        etatField.getItems().setAll(0, 1);
        etatField.setValue(etatField.getItems().get(0));
    }

    public void handleOk() {
        if(champSelected != null) {
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
}