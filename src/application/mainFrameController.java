package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class mainFrameController {

	int num = 0;
	int numDecal = 0;
	csv_reader R;
	ObservableList<String> correctWords = FXCollections.observableArrayList();

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
	private Button helpB;

	@FXML
	private Button validateB;

	@FXML
	private Button skipB;

	@FXML
	private ComboBox lessonSelect;

	@FXML
	private Label def;

	@FXML
	private Label hint;

	@FXML
	private ListView<String> lessonsL;

	@FXML
	private TextField answerField;

	public mainFrameController() {

	}

	public void showLessons() throws FileNotFoundException{
		mainScreen.setVisible(false);

		num = 0;
		numDecal = 0;
		correctWords.clear();

		R = new csv_reader("src/application/files/l0.csv");
		System.out.println(R.fourFetcher(num,0));
		def.setText(R.fourFetcher(num,1));
		lessonsScreen.setVisible(true);
	}

	public void validateWord(){
		if(answerField.getText().equals(R.fourFetcher(num,0))){
			if (num!=19){
				hint.setText("Correct !");
				correctWords.add(R.fourFetcher(num,0));
				lessonsL.setItems(correctWords);
				num++;
				numDecal++;
				def.setText(R.fourFetcher(num,1));
			}
			else {
				String awt = "Your Score is" + Integer.toString(num-numDecal) +"/"+ Integer.toString(num);
				def.setText("You finished all the words !");
				hint.setText(awt);
				correctWords.add(R.fourFetcher(num,0));
				lessonsL.setItems(correctWords);
			}
		}
		else{
			hint.setText("Not Quite. Try again !");
		}
	}

	public void helpPlease(){
		hint.setText(R.fourFetcher(num,2));
	}

	public void skipPlease(){
		hint.setText("The word was : " + R.fourFetcher(num,0));
		num++;
		def.setText(R.fourFetcher(num,1));
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
