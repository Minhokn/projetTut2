package application.model;
import java.net.URL;

import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class Maps {
	private WebView webView;
    private JSObject javascriptOBJ;

    public Maps(String mapHTML, APIGoogleMap controller) {

        webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.setJavaScriptEnabled(true);

        final URL urlGoogleMaps = getClass().getResource("/application/view/"+ mapHTML+".html");
        webEngine.load(urlGoogleMaps.toExternalForm());
        
    }

	public void setParent(StackPane googleMaps) {
		googleMaps.getChildren().setAll(webView);
	}}
