package application.controller;

import application.model.Botteleuse;
import application.model.Machine;
import application.model.database;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditMachineBotteleuseController {

    @FXML private VBox vbox;
    @FXML private TextField marqueField;
    @FXML private TextField modeleField;
    @FXML private ComboBox<Integer> etatField;
    @FXML private ComboBox<String> typeField;

    private Botteleuse botteleuseSelected;
    private Machine machineSelected;
    private machineController botteleuseController;


    public void initialize() {
        etatField.getItems().setAll(0, 1);
        etatField.setValue(etatField.getItems().get(0));
    }

    public void handleOk() {
        if(botteleuseSelected != null && machineSelected != null) {
            machineSelected.setMarque(marqueField.getText());
            machineSelected.setModele(modeleField.getText());
            machineSelected.setEtat(etatField.getValue());
            botteleuseSelected.setType(typeField.getValue());

            new database().editMachine(machineSelected);
            new database().editBotteleuse(botteleuseSelected);
        } else {
            new database().addBotteleuse(typeField.getValue());
            new database().addMachine(marqueField.getText(), modeleField.getText(), etatField.getValue());
        }

      //  machineController.refreshData();

        ((Stage) vbox.getScene().getWindow()).close();
    }

    public void handleCancel() {
        ((Stage) vbox.getScene().getWindow()).close();
    }

    public void setMachineSelected(Botteleuse botteleuse) {
        this.botteleuseSelected = botteleuse;
        marqueField.setText(botteleuse.getMarque());
        modeleField.setText(botteleuse.getModele());
        etatField.setValue(botteleuse.getEtat());
        typeField.setValue(botteleuse.getType());
    }

    public void setBotteleuseController(machineController botteleuseController) {
        this.botteleuseController = botteleuseController;
    }
}
