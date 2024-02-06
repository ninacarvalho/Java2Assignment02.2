package task1;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RankSys extends Application {

    @Override
    public void start(Stage primaryStage)  {

        primaryStage.setTitle("HUMBER COLLEGE STUDENT RANKING SYSTEM");
       
        // CREATING BUTTONS
        Button submitButton = new Button("Submit Query");
        Button exitButton = new Button("Exit");

        // CREATING TEXT LABELS
        Text yearTxt = new Text("Enter the year:");
        Text genderTxt = new Text("Enter the Gender:");
        Text nameTxt = new Text("Enter the name:");

        // CREATING TEXT FIELD
        TextField yearField = new TextField();
        TextField genderField = new TextField();
        TextField nameField = new TextField();

        // CREATING A GRID PANE
        GridPane gridPane = new GridPane();

        // GRIDPANE SIZE
        gridPane.setMinSize(500, 300);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        // ALIGNMENT & PADDING
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        
        gridPane.add(yearTxt, 0, 0);
        gridPane.add(yearField, 1, 0);

        gridPane.add(genderTxt, 0, 1);
        gridPane.add(genderField, 1, 1);

        gridPane.add(nameTxt, 0, 2);
        gridPane.add(nameField, 1, 2);

        // ADDING BUTTONS
        gridPane.add(submitButton, 0, 3);
        gridPane.add(exitButton, 1, 3);
        
        //ADDING BACKGROUND COLOR
//      gridPane.setStyle("-fx-background-color: linear-gradient(to bottom, #0000FF, #FFFF00);");
        gridPane.setStyle("-fx-background-color: #e2e8c0;");

        // CREATING A SCENE
        Scene scene = new Scene(gridPane);
                     
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // RESULT STAGE
     	// RESULT WINDOW
     	Label resultLabel = new Label();
     		
     	Button okButton = new Button("OK");
     		
     	VBox vbox = new VBox(10, resultLabel, okButton);
     		
     	vbox.setAlignment(Pos.CENTER);		
     	vbox.setPadding(new Insets(20));
     	vbox.setStyle("-fx-background-color: #e2e8c0;");
     		
     	Scene resultScene = new Scene(vbox, 350, 150);
     	
     		
     	Stage resultStage = new Stage();
     	resultStage.setScene(resultScene);
     	resultStage.setTitle("NAME RANKING");
     		
     	// BUTTONS CONTROL
     	// BUTTON SUBMIT QUERY
     	submitButton.setOnAction(event -> {	
     		try {
     			int year = Integer.parseInt(yearField.getText());
     			// GENERATE A RANDOM RANKING
     			Random randRanking = new Random();
     			resultLabel.setText(String.format("The ranking of name %s in year %s is %s.",nameField.getText(), year, randRanking.nextInt(1, 200)));			
     			resultStage.show();
     		}
     		catch (NumberFormatException ex) {
     			resultLabel.setText("Invalid Year!");	
     			resultStage.setTitle("Message");
     			resultStage.show();
     		}
     	});
     		
     	// BUTTON EXIT
     	exitButton.setOnAction(event -> {
     		primaryStage.close();
     		resultStage.close();
     	});
     	
     	// BUTTON OK
     	okButton.setOnAction(event -> {
     		resultStage.close();
     	});
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
