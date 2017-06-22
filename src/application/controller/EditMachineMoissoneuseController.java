package application.controller;

import application.model.Botteleuse;
import application.model.Machine;
import application.model.Moissoneuse;
import application.model.database;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditMachineMoissoneuseController {

    @FXML private VBox vbox;
    @FXML private TextField marqueField;
    @FXML private TextField modeleField;
    @FXML private ComboBox<Integer> etatField;

    @FXML private TextField tailleTremisField;
    @FXML private TextField tailleReservoirField;
    @FXML private TextField largeurMoissonneuseField;
    @FXML private TextField hauteurMoissonneuseField;
    @FXML private TextField largeurCoupeField;
    @FXML private TextField consommationChampField;
    @FXML private TextField consommationRouteField;
    @FXML private TextField poidsField;


    private Machine machineSelected;
    private Moissoneuse moissoneuseSelected;
    private machineController machineController;

    private machineController botteleuseController;



    public void initialize() {
        etatField.getItems().setAll(0, 1);
        etatField.setValue(etatField.getItems().get(0));
    }

    public void handleOk() {
        if(machineSelected != null && moissoneuseSelected != null) {
            machineSelected.setMarque(marqueField.getText());
            machineSelected.setModele(modeleField.getText());
            machineSelected.setEtat(etatField.getValue());
           // moissoneuseSelected.setCapaciteReserve(marqueField.getText());
           // moissoneuseSelected.setConsoF(marqueField.getText());
            //moissoneuseSelected.setConsoR(marqueField.getText());
            //moissoneuseSelected.setHauteur(marqueField.getText());
            //moissoneuseSelected.setLgCoupe(marqueField.getText());
            //moissoneuseSelected.setLgRoute(marqueField.getText());



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
}
