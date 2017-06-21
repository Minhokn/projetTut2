package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;

public class commandeController implements Initializable,MapComponentInitializedListener {
	
	@FXML ListView idListAttribuerTracteur;
	@FXML ListView idListAttribuerMoissoneuse;
	@FXML RadioButton idRadioButtonCamionCiterneOui;
	@FXML RadioButton  idRadioButtonCamionCiterneNon;
	@FXML RadioButton  idRadioButtonVehiculeHescorteOui;
	@FXML RadioButton  idRadioButtonVehiculeHescorteNon;
	@FXML Button idBouttonValiderChoix;
	
	@FXML GoogleMapView mapView;
	private GoogleMap map;
	private static final int ZOOM = 12;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mapView.addMapInializedListener(this);
		
	}
	@Override
	public void mapInitialized() {
		
		 MapOptions mapOptions = new MapOptions();
	        mapOptions.center(new LatLong(47.970793, -1.448495))
         .overviewMapControl(false)
         .panControl(true)
         .rotateControl(false)
         .scaleControl(false)
         .streetViewControl(false)
         .zoomControl(true)
         .zoom(ZOOM).mapType(MapTypeIdEnum.SATELLITE);
	     map = mapView.createMap(mapOptions);
	}	
}
