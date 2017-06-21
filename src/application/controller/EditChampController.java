package application.controller;

import application.model.Champ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by Thecr on 21/06/2017.
 */
public class EditChampController {

    @FXML private TextField surfaceField;
    @FXML private TextField adresseField;
    @FXML private TextField coordoneeGPSField;
    @FXML private TextField typeField;
    @FXML private TextField clientField;

    private Champ champSelected;

    public void handleOk(ActionEvent actionEvent) {
    }

    public void handleCancel(ActionEvent actionEvent) {
    }

    public void setChampSelected(Champ champ) {
        this.champSelected = champ;
    }
}
