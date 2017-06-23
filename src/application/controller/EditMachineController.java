package application.controller;

import application.model.Machine;
import application.model.database;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditMachineController {

    @FXML private VBox vbox;
    @FXML private TextField marqueField;
    @FXML private TextField modeleField;
    @FXML private ComboBox<Integer> etatField;

    private Machine machineSelected;
    private machineController machineController;

    /**
     * boite de dialogue si erreur
     */
    private Stage dialogStage;
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    public void initialize() {
        etatField.getItems().setAll(0, 1);
        etatField.setValue(etatField.getItems().get(0));
    }

    public void handleOk() {
        if(machineSelected != null || rentrerInvalide()) {
            machineSelected.setMarque(marqueField.getText());
            machineSelected.setModele(modeleField.getText());
            machineSelected.setEtat(etatField.getValue());

            new database().editMachine(machineSelected);
        } else {
            new database().addMachine(marqueField.getText(), modeleField.getText(), etatField.getValue());
        }

        machineController.refreshData();

        ((Stage) vbox.getScene().getWindow()).close();
    }

    public void handleCancel() {
        ((Stage) vbox.getScene().getWindow()).close();
    }

    public void setMachineSelected(Machine machine) {
        this.machineSelected = machine;

        marqueField.setText(machine.getMarque());
        modeleField.setText(machine.getModele());
        etatField.setValue(machine.getEtat());
    }

    public void setMachineController(machineController machineController) {
        this.machineController = machineController;
    }





    private boolean rentrerInvalide() {
        String errorMessage = "";

        if (marqueField.getText() == null || marqueField.getText().length() == 0) {
            errorMessage += "Marque invalide!\n";
        }
        if (modeleField.getText() == null || modeleField.getText().length() == 0) {
            errorMessage += "Modele invalide!\n";
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
}}
