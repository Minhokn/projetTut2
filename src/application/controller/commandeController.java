package application.controller;

import java.net.URL;
import java.util.ResourceBundle;


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

	@Override
	public void initialize(URL location, ResourceBundle resources) {


	}

}
