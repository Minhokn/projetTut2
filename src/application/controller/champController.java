package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import application.model.Champ;
import application.model.database;


public class champController implements Initializable {


    @FXML
    TableView<Champ> champsTableau;

    @FXML
    private TableColumn<Champ, Integer> surface;
    @FXML
    private TableColumn<Champ, String> adresse;
    @FXML
    private TableColumn<Champ, String> coordoneeGPS;
    @FXML
    private TableColumn<Champ, String> type;

    private ObservableList<Champ> champs = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        surface.setPrefWidth(100);
        surface.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getSurf_ch()));
        adresse.setPrefWidth(100);
        adresse.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAdr_ch()));
        coordoneeGPS.setPrefWidth(100);
        coordoneeGPS.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGPS_ch()));
        type.setPrefWidth(100);
        type.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCult_ch()));

        champs.addAll(new database().recupererChamps());

        champsTableau.getItems().setAll(champs);

    }

    public void editChamp() {
        if (champsTableau.getSelectionModel().getSelectedItem() != null) {
            newFenetre(champsTableau.getSelectionModel().getSelectedItem());
        }


    }

    public void addChamp() {
        newFenetre();
    }

    public void deleteChamp() {

    }

    public void newFenetre() {
        Stage primaryStage = new Stage();
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/application/view/editerChamps.fxml"));
            Parent root = loader.load();
            primaryStage.setTitle("Edit Personne");

            editController controller = loader.getController();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();


        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void newFenetre(Champ champ) {

        Stage primaryStage = new Stage();
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/application/view/editerChamps.fxml"));
            Parent root = loader.load();
            primaryStage.setTitle("Edit Person");

            EditChampController controller = loader.getController();
            controller.setChampSelected(champ);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();


        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
