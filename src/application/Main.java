package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("PrMeGuMi");

		/*try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}*/

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("mainFrame.fxml"));
		loader.setControllerFactory(iC-> new mainFrameController() );
		Parent root = loader.load();

		primaryStage.setOnCloseRequest(event -> {
			Platform.exit();
		});

		primaryStage.setScene(new Scene(root, 800, 475));
		primaryStage.setTitle("Pr.MeG 0.1");
		primaryStage.show();
		primaryStage.toBack();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
