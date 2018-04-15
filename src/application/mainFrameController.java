package application;

import java.io.FileNotFoundException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class mainFrameController {

	@FXML
	private AnchorPane mainScreen;

	@FXML
	private AnchorPane lessonsScreen;

	@FXML
	private Button LessonsB;

	@FXML
	private Button GlossaryB;

	@FXML
	private Button UpdateB;

	@FXML
	private Button OptionsB;

	@FXML
	private ListView<String> lessonsL;

	public mainFrameController() {

	}

	public void showLessons() throws FileNotFoundException{
		mainScreen.setVisible(false);
		ObservableList<String> lessonsList = FXCollections.observableArrayList();
		csv_reader R = new csv_reader("src/application/files/list.csv");
		for (int i=1; i<=Integer.parseInt(R.vocFetcher(0,0)); i++){
			lessonsList.addAll(R.vocFetcher(0,i));
		}
		System.out.println(lessonsList);
		lessonsL.setItems(lessonsList);
		lessonsScreen.setVisible(true);
	}

	public void showGlossary(){
		mainScreen.setVisible(false);
	}

	public void showUpdate(){
		mainScreen.setVisible(false);
	}

	public void showOptions(){
		mainScreen.setVisible(false);
	}

}
