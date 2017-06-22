package application.model;
import java.net.URL;

import application.Main;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class Maps {
	private WebView webView;
    private JSObject javascriptOBJ;

    public Maps(String mapHTML) {

        webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.setJavaScriptEnabled(true);

        final URL urlGoogleMaps = getClass().getResource("/application/view/"+ mapHTML+".html");
        webEngine.load(urlGoogleMaps.toExternalForm());


        javascriptOBJ = (JSObject) webView.getEngine().executeScript("window");
        javascriptOBJ.setMember("jsInterface", Main.getJsInterface());
        webEngine.setOnAlert(e -> System.out.println(e.toString()));
        webEngine.setOnError(e -> System.err.println(e.toString()));
    }
    public void addChamp(Champ champ){
        javascriptOBJ.call("addChamp",champ.getId_ch(),champ.getAdr_ch(),champ.getCult_ch(),champ.getSurf_ch(),champ.getGPS_ch());
    };
	public void setParent(StackPane googleMaps) {
		googleMaps.getChildren().setAll(webView);
	}
}
