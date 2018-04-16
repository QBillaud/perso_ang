package application;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class mainFrameController implements Initializable {

	int num = 0;
	int numDecal = 0;
	csv_reader R;
	boolean tec = false;
	ObservableList<String> correctWords = FXCollections.observableArrayList();

	@FXML
	private AnchorPane mainScreen;

	@FXML
	private AnchorPane lessonsScreen;

	@FXML
	private AnchorPane glossaryScreen;

	@FXML
	private AnchorPane updateScreen;

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
	private Button validateGlossB;

	@FXML
	private Button testMyselfB;

	@FXML
	private Button skipB;

	@FXML
	private Button addB;

	@FXML
	private ChoiceBox lessonSelect;
	ObservableList<String> elementsOfBox = FXCollections.observableArrayList();

	@FXML
	private Label def;

	@FXML
	private Label hint;

	@FXML
	private Label IOL;

	@FXML
	private Label awx;

	@FXML
	private ListView<String> lessonsL;

	@FXML
	private ListView<String> vocList;
	ObservableList<String> vocLister = FXCollections.observableArrayList();

	@FXML
	private TextField answerField;

	@FXML
	private TextField tmField;

	@FXML
	private TextField add0;
	@FXML
	private TextArea add1;
	@FXML
	private TextArea add2;
	@FXML
	private TextField add3;

	@FXML
	private MenuItem backToMenu;

	public mainFrameController() {

	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			R = new csv_reader("src/application/files/list.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=1; i<=Integer.parseInt(R.fourFetcher(0,0)); i++){
			elementsOfBox.add(R.fourFetcher(0,i));
		}
		lessonSelect.getItems().clear();
		lessonSelect.setItems(elementsOfBox);
	}

	public void showLessons(){
		mainScreen.setVisible(false);

		num = 0;
		numDecal = 0;
		correctWords.clear();

		try {
			R = new csv_reader("src/application/files/"+ lessonSelect.getSelectionModel().getSelectedItem() + ".csv");
		} catch (FileNotFoundException e) {
			try {
				R = new csv_reader("src/application/files/lesson0.csv");
			} catch (FileNotFoundException e2) {
			}
		}
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
				num++;
				numDecal++;
				String awt = "Your Score is" + Integer.toString(numDecal) +"/"+ Integer.toString(num+1);
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
		if(num==20){
			showMenu();
		} else {
			if(num!=19){
				hint.setText("The word was : " + R.fourFetcher(num,0));
				num++;
				def.setText(R.fourFetcher(num,1));
			} else {
				String awt = "Your Score is" + Integer.toString(num-numDecal) +"/"+ Integer.toString(num);
				def.setText("You finished all the words !");
				hint.setText(awt);
			}
		}
	}

	public void showGlossary(){
		mainScreen.setVisible(false);

		try {
			R = new csv_reader("src/application/files/"+ lessonSelect.getSelectionModel().getSelectedItem() + ".csv");
		} catch (FileNotFoundException e) {
			try {
				R = new csv_reader("src/application/files/lesson0.csv");
			} catch (FileNotFoundException e2) {
			}
		}
		for(int i=0; i<20; i++){
			vocLister.add(R.fourFetcher(i,0) +" = "+ R.fourFetcher(i,3));
		}

		vocList.setItems(vocLister);

		glossaryScreen.setVisible(true);
	}

	public void selfTest(){
		vocLister.clear();
		vocLister.add(R.fourFetcher(0,0));
		vocList.setItems(vocLister);
		num = 0;
		tec = true;
	}

	public void glossValidate(){
		if(tec){
			String a = tmField.getText();
			String b = R.fourFetcher(num,3);
			if(a.equals(b)){
				if (num!=19){
					IOL.setText("Correct");
					vocLister.remove(vocLister.size()-1, vocLister.size()-1);
					vocLister.add(R.fourFetcher(num,0) + " = " + R.fourFetcher(num,3));
					num++;
				}
				else {
					IOL.setText("Correct");
					vocLister.remove(vocLister.size()-1, vocLister.size()-1);
					vocLister.add(R.fourFetcher(num,0) + " = " + R.fourFetcher(num,3));
					tec = false;
				}
			}
			else{
				IOL.setText("Wrong");
				vocLister.remove(vocLister.size()-1, vocLister.size()-1);
				vocLister.add(R.fourFetcher(num,0) + " = " + R.fourFetcher(num,3));
				System.out.println(tmField.getText().toString());
				System.out.println(R.fourFetcher(num,3).toString());
				num++;
			}
			vocLister.add(R.fourFetcher(num,0));
			vocList.setItems(vocLister);
		}
	}

	public void showMenu(){
		lessonsScreen.setVisible(false);
		glossaryScreen.setVisible(false);
		vocList.getItems().clear();
		lessonsL.getItems().clear();
		def.setText("");
		hint.setText("");
		IOL.setText("");
		num = 0;
		mainScreen.setVisible(true);
	}
}
