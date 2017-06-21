package application.controller;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;

public class commandeController implements Initializable {

	@FXML ListView idListAttribuerTracteur;
	@FXML ListView idListAttribuerMoissoneuse;
	@FXML RadioButton idRadioButtonCamionCiterneOui;
	@FXML RadioButton  idRadioButtonCamionCiterneNon;
	@FXML RadioButton  idRadioButtonVehiculeHescorteOui;
	@FXML RadioButton  idRadioButtonVehiculeHescorteNon;
	@FXML Button idBouttonValiderChoix;

	@Override
	public void initialize(URL location, ResourceBundle resources) {


	}

}
