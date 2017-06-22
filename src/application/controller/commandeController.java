package application.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import application.model.Champ;
import application.model.Moissoneuse;
import application.model.Tracteur;
import application.model.database;
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

	private List<Champ> listChamps;
	private List<Tracteur> listTracteurs;
	private List<Moissoneuse> listMoissonneuses;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listChamps = new database().recupererChamps();
		champSelector.getItems().setAll(listChamps);
		champSelector.setValue(champSelector.getItems().get(0));

		//listTracteurs = new database().recupererTracteurs();
		//champSelector.getItems().setAll(listChamps);
		//champSelector.setValue(champSelector.getItems().get(0));

		listMoissonneuses = new database().recupererMoissonneuse();
		moissonneuseSelector.getItems().setAll(listMoissonneuses);
		moissonneuseSelector.setValue(moissonneuseSelector.getItems().get(0));

	}

}
