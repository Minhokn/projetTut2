package application.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import application.model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class commandeController implements Initializable {

	@FXML TableView viewTracteur;
	@FXML TableView viewMoissonneuse;
	@FXML ComboBox champSelector;
	@FXML ComboBox moissonneuseSelector;
	@FXML ComboBox tracteurSelector;
	@FXML RadioButton ouiR;
	@FXML RadioButton  nonR;
	@FXML RadioButton  ouiE;
	@FXML RadioButton  nonE;
	@FXML Button valider;
	@FXML
	private TableColumn<Machine, String> marqueColonne;
	@FXML
	private TableColumn<Machine, String> modeleColonne;
	@FXML
	private TableColumn<Machine, Integer> etatColonne;
	@FXML
	private TableColumn<Machine, String> marqueColonnet;
	@FXML
	private TableColumn<Machine, String> modeleColonnet;
	@FXML
	private TableColumn<Machine, Integer> etatColonnet;

	private ObservableList<Machine> machineList = FXCollections.observableArrayList();

	private List<Champ> listChamps;
	private List<Tracteur> listTracteurs;
	private List<Moissoneuse> listMoissonneuses;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listChamps = new database().recupererChamps();
		champSelector.getItems().setAll(listChamps);
		champSelector.setValue(champSelector.getItems().get(0));

		listTracteurs = new database().recupererTracteur();
		tracteurSelector.getItems().setAll(listTracteurs);
		tracteurSelector.setValue(tracteurSelector.getItems().get(0));

		listMoissonneuses = new database().recupererMoissonneuse();
		moissonneuseSelector.getItems().setAll(listMoissonneuses);
		moissonneuseSelector.setValue(moissonneuseSelector.getItems().get(0));


		marqueColonne.setPrefWidth(100);
		marqueColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarque()));
		modeleColonne.setPrefWidth(100);
		modeleColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModele()));
		etatColonne.setPrefWidth(100);
		etatColonne.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEtat()));

		marqueColonnet.setPrefWidth(100);
		marqueColonnet.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarque()));
		modeleColonnet.setPrefWidth(100);
		modeleColonnet.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModele()));
		etatColonnet.setPrefWidth(100);
		etatColonnet.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEtat()));

	}

}
