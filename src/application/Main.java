package application;
	
import application.controller.JsInterface;
import application.model.JSON;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	public static JSON getMeJson() {
		return meJson;
	}

	public static JsInterface jsInterface = new JsInterface();

	public static void setMeJson(JSON meJson) {
		Main.meJson = meJson;
	}

	private static JSON meJson = new JSON ();

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/RootLayout.fxml"));
			primaryStage.setTitle("Farm Simulator");
			Scene scene = new Scene(root,1200,750);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}


	public static JsInterface getJsInterface() {
		return jsInterface;
	}

	public static void setJsInterface(JsInterface jsInterface) {
		Main.jsInterface = jsInterface;
	}
}
