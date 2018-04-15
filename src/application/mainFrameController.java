package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

	public mainFrameController() {

	}

	public void showLessons(){
		mainScreen.setVisible(false);
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
