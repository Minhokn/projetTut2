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

    /**
     * Genere la map
     * @param mapHTML
     */
    public Maps(String mapHTML) {
        chargement(mapHTML);

    }

    /**
     * Ajouter des champs a la map
     * @param champ
     */
    public void addChamp(Champ champ){
        javascriptOBJ.call("addChamp",champ.getId_ch(),champ.getAdr_ch(),champ.getCult_ch(),champ.getSurf_ch(),champ.getGPS_ch());
    };

    /**
     * Mettre la map dans la webview
     * @param googleMaps
     */
	public void setParent(StackPane googleMaps) {
		googleMaps.getChildren().setAll(webView);
	}

    /**
     * Enlever la map
     * @param googleMaps
     */
    public void enleverParent(StackPane googleMaps) {
        googleMaps.getChildren().remove(webView);
    }

    /**
     * Charger la map
     * @param url
     */
	public void chargement(String url){
        webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.setJavaScriptEnabled(true);

        final URL urlGoogleMaps = getClass().getResource("/application/view/"+ url+".html");
        webEngine.load(urlGoogleMaps.toExternalForm());


        javascriptOBJ = (JSObject) webView.getEngine().executeScript("window");
        javascriptOBJ.setMember("jsInterface", Main.getJsInterface());
        webEngine.setOnAlert(e -> System.out.println(e.toString()));
        webEngine.setOnError(e -> System.err.println(e.toString()));
    }
}
