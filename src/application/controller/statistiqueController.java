package application.controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import application.model.database;

public class statistiqueController implements Initializable {
	
		@FXML
		Label duréeMoisson;
		@FXML
		Label distanceKM;
		@FXML
		Label tonneRecoltées;
		@FXML
		Label tonnesParHectar;
		@FXML
		Circle cercle1;
		@FXML
		Circle cercle2;
		@FXML
		Circle cercle3;
		@FXML
		Circle cercle4;
		@FXML
		AnchorPane anchor1;
		@FXML
		AnchorPane anchor2;

	/**
	 * Recuperer les donnees
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setDuréeMoisson(database.nbrDuréeMoisson());
		setDistanceKM(database.nbrDistanceKM());
		setTonneRecoltées(database.nbrTonneRecoltées());
		setTonnesParHectar(database.nbrTonnesParHectar());
		
	}

	/**
	 * Duree de la moisson totale
	 * @param nbr
	 */
	public void setDuréeMoisson(double nbr){
		duréeMoisson.setText("" + nbr);
		/**
		 * centre le texte
		 */
		duréeMoisson.setLayoutX(cercle1.getLayoutX()-(28*Math.sqrt(Math.sqrt(Math.sqrt(nbr)))));
	}

	/**
	 * Distance km
	 * @param nbr
	 */
	public void setDistanceKM(double nbr){
		distanceKM.setText("" + nbr);
		distanceKM.setLayoutX(cercle2.getLayoutX()-(28*Math.sqrt(Math.sqrt(Math.sqrt(nbr)))));
	}

	/**
	 * Tonne recoltes
	 * @param nbr
	 */
	public void setTonneRecoltées(double nbr){
		nbr = 225;
		tonneRecoltées.setText("" + nbr);
		tonneRecoltées.setLayoutX(cercle3.getLayoutX()-(28*Math.sqrt(Math.sqrt(Math.sqrt(nbr)))));
	}

	/**
	 * Tonne par hectar
	 * @param nbr
	 */
	public void setTonnesParHectar(double nbr){
		tonnesParHectar.setText("" + nbr);
		tonnesParHectar.setLayoutX(cercle4.getLayoutX()-(28*Math.sqrt(Math.sqrt(Math.sqrt(nbr)))));
	}
	
	
	
	
	
}
