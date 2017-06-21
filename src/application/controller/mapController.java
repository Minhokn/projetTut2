package application.controller;

import application.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;

import java.util.List;


public class mapController implements APIGoogleMap {
	
	@FXML StackPane googleMaps;
	@FXML private ComboBox<Client> NdC;
    @FXML private ComboBox<Champ> AdC;
    @FXML private ComboBox<Champ> dc1;
    @FXML private ComboBox<Champ> dc2;
	
	private Maps map;
	private static final int ZOOM = 12;
	private List<Client> listClients;
    private List<Champ> listChamps;
	
	public void initialize() {
		map=new Maps("map",this);
		map.setParent(googleMaps);

		listClients = new database().recupererClients();
		NdC.getItems().setAll(listClients);
		NdC.setValue(NdC.getItems().get(0));

        listChamps = new database().recupererChamps();

        AdC.getItems().setAll(listChamps);
        AdC.setValue(AdC.getItems().get(0));


        dc1.getItems().setAll(listChamps);
        dc1.setValue(dc1.getItems().get(0));


        dc2.getItems().setAll(listChamps);
        dc2.setValue(dc2.getItems().get(0));
	}


}
