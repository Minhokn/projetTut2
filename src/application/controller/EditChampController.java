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

/**
 * Created by Thecr on 21/06/2017.
 */
public class EditChampController {

    @FXML private VBox vbox;

    @FXML private TextField surfaceField;
    @FXML private TextField adresseField;
    @FXML private TextField coordoneeGPSField;
    @FXML private TextField typeField;
    @FXML private ComboBox<Client> clientField;

    private Champ champSelected;

    private List<Client> listClients;

    public void initialize() {
        listClients = new database().recupererClients();
        clientField.getItems().setAll(listClients);
        clientField.setValue(clientField.getItems().get(0));
    }

    public void handleOk() {
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

        for(Client client : listClients)
            if(client.equals(champ.getClient()))
                listClients.remove(client);

        clientField.setValue(champ.getClient());
    }
}
