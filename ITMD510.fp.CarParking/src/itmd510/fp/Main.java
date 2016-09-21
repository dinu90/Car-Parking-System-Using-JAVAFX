package itmd510.fp;
	
import itmd510.fp.common.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Main Class - the application starts executing here. 
 * @author Dinesh_Ganesan
 *
 */
public class Main extends Application {
	public static Stage stage;
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(Constants.LOGIN_URL));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Constants.CSS_URL);
			stage.setTitle("Login");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}