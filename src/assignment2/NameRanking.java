package assignment2;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NameRanking extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		// contents of main window
		
		// labels of main window
		Label yearLabel = new Label("Enter the Year: ");
		Label genderLabel = new Label("Enter the Gender: ");
		Label nameLabel = new Label("Enter the Name");
		
		// text fields of main window
		TextField yearField = new TextField();
		TextField genderField = new TextField();
		TextField nameField = new TextField();
		
		// buttons of main window
		Button submitButton = new Button("Submit Query");
		Button exitButton = new Button("Exit");
				
		// main window pane
		GridPane mainPane = new GridPane();
		
		// add components to pane and set position
		mainPane.add(yearLabel, 1, 1);
		mainPane.add(yearField, 2, 1);
		mainPane.add(genderLabel, 1, 2);
		mainPane.add(genderField, 2, 2);
		mainPane.add(nameLabel, 1, 3);
		mainPane.add(nameField, 2, 3);
		mainPane.add(submitButton, 1, 4);
		mainPane.add(exitButton, 2, 4);
		
		// set alignment and padding of pane
		mainPane.setAlignment(Pos.CENTER);
		mainPane.setPadding(new Insets(20));
		
		// scene of main window
		Scene mainScene = new Scene(mainPane, 400, 300);
		
		primaryStage.setTitle("Search Name Ranking Application");
		primaryStage.setScene(mainScene);
		primaryStage.show();
		
		// contents of result stage
		// components in result window
		Label resultLabel = new Label();
		
		Button okButton = new Button("OK");
		
		VBox vbox = new VBox(10, resultLabel, okButton);
		
		vbox.setAlignment(Pos.CENTER);
			
		vbox.setPadding(new Insets(20));
		
		Scene resultScene = new Scene(vbox, 400, 300);
		
		Stage resultStage = new Stage();
		resultStage.setScene(resultScene);
		resultStage.setTitle("Name Ranking");
		
		// buttons event control
		// Action for button Submit
		submitButton.setOnAction(event -> {	
			try {
				int year = Integer.parseInt(yearField.getText());
				Random randRanking = new Random();
				resultLabel.setText(String.format("The ranking of name %s in year %s is %s.",nameField.getText(), yearField.getText(), randRanking.nextInt(1, 200)));			
				resultStage.show();
			}
			catch (NumberFormatException ex) {
				resultLabel.setText("Invalid Year!");	
				resultStage.setTitle("Message");
				resultStage.show();
			}
		});
		
		// Action for button Exit
		exitButton.setOnAction(event -> {
			primaryStage.close();
			resultStage.close();
		});
		
		// Action for button OK
		okButton.setOnAction(event -> {
			resultStage.close();
		});
	}
}
