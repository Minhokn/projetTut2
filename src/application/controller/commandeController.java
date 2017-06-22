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

	@FXML TableView<Tracteur> viewTracteur;
	@FXML TableView<Moissoneuse> viewMoissonneuse;

	@FXML ComboBox<Champ> champSelector;
	@FXML ComboBox<Moissoneuse> moissonneuseSelector;
	@FXML ComboBox<Tracteur> tracteurSelector;
	@FXML RadioButton ouiR;
	@FXML RadioButton  nonR;
	@FXML RadioButton  ouiE;
	@FXML RadioButton  nonE;
	@FXML Button valider;
	@FXML
	private TableColumn<Moissoneuse, String> marqueColonne;
	@FXML
	private TableColumn<Moissoneuse, String> modeleColonne;
	@FXML
	private TableColumn<Moissoneuse, Integer> etatColonne;
	@FXML
	private TableColumn<Tracteur, String> marqueColonnet;
	@FXML
	private TableColumn<Tracteur, String> modeleColonnet;
	@FXML
	private TableColumn<Tracteur, Integer> etatColonnet;

	private ObservableList<Moissoneuse> moissonneuseList = FXCollections.observableArrayList();

	private List<Champ> listChamps;
	private List<Moissoneuse> listMoissonneuses;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listChamps = new database().recupererChamps();
		champSelector.getItems().setAll(listChamps);
		champSelector.setValue(champSelector.getItems().get(0));

		tracteurSelector.getItems().setAll(new database().recupererTracteur());
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
		marqueColonnet.setCellValueFactory(cellData -> {
			System.out.println(cellData.getValue());
			return new SimpleStringProperty(cellData.getValue().getMarque());

		});
		modeleColonnet.setPrefWidth(100);
		modeleColonnet.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModele()));
		etatColonnet.setPrefWidth(100);
		etatColonnet.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEtat()));

	}
	@FXML
	public void addUnTracteur(){
		viewTracteur.getItems().add(tracteurSelector.getValue());
	}

	@FXML
	public void adduneMoissonneuse(){
		viewMoissonneuse.getItems().add(moissonneuseSelector.getValue());
	}
	@FXML
	public void verifierOR(){
		if(nonR.isSelected()){
			nonR.setSelected(false);
		}
	}
	@FXML
	public void verifierNR(){
		if(ouiR.isSelected()){
			ouiR.setSelected(false);
		}
	}
	@FXML
	public void verifierOE(){
		if(nonE.isSelected()){
			nonE.setSelected(false);
		}
	}
	@FXML
	public void verifierNE(){
		if(ouiE.isSelected()){
			ouiE.setSelected(false);
		}
	}
}
