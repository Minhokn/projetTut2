package application.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import application.model.APIGoogleMap;
import application.model.Maps;


public class mapController implements APIGoogleMap {
	
	@FXML StackPane googleMaps;
	
	private Maps map;
	private static final int ZOOM = 12;
	
	public void initialize() {
		map=new Maps("map",this);
		map.setParent(googleMaps);
	}


}
