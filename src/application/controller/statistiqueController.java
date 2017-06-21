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
		Label dur�eMoisson;
		@FXML
		Label distanceKM;
		@FXML
		Label tonneRecolt�es;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setDur�eMoisson(database.nbrDur�eMoisson());
		setDistanceKM(database.nbrDistanceKM());
		setTonneRecolt�es(database.nbrTonneRecolt�es());
		setTonnesParHectar(database.nbrTonnesParHectar());
		
	}
	
	public void setDur�eMoisson(double nbr){
		dur�eMoisson.setText("" + nbr);
		dur�eMoisson.setLayoutX(cercle1.getLayoutX()-(28*Math.sqrt(Math.sqrt(Math.sqrt(nbr)))));
	}
	
	public void setDistanceKM(double nbr){
		distanceKM.setText("" + nbr);
		distanceKM.setLayoutX(cercle2.getLayoutX()-(28*Math.sqrt(Math.sqrt(Math.sqrt(nbr)))));
	}

	public void setTonneRecolt�es(double nbr){
		nbr = 225;
		tonneRecolt�es.setText("" + nbr);
		tonneRecolt�es.setLayoutX(cercle3.getLayoutX()-(28*Math.sqrt(Math.sqrt(Math.sqrt(nbr)))));
	}

	public void setTonnesParHectar(double nbr){
		tonnesParHectar.setText("" + nbr);
		tonnesParHectar.setLayoutX(cercle4.getLayoutX()-(28*Math.sqrt(Math.sqrt(Math.sqrt(nbr)))));
	}
	
	
	
	
	
}
