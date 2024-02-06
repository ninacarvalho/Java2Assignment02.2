package GAss;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RankSys extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Search Name Ranking Application");
       
        

        // CREATING BUTTONS
        Button btn1 = new Button("Submit Query");
        Button btn2 = new Button("Exit");

        // CREATING TEXT LABELS
        Text txt1 = new Text("Enter the year:");
        Text txt2 = new Text("Enter the Gender:");
        Text txt3 = new Text("Enter the name:");
        

        // CREATING TEXT FIELD
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();

        // CREATING A GRID PANE
        GridPane gridPane = new GridPane();

        // GRIDPANE SIZE
        gridPane.setMinSize(500, 300);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        // ALIGNMENT
        gridPane.setAlignment(Pos.CENTER);
        
        gridPane.add(txt1, 0, 0);
        gridPane.add(textField1, 1, 0);

        gridPane.add(txt2, 0, 1);
        gridPane.add(textField2, 1, 1);

        gridPane.add(txt3, 0, 2); // 
        gridPane.add(textField3, 1, 2); //

        // ADDING BUTTONS
        gridPane.add(btn1, 0, 3);
        gridPane.add(btn2, 1, 3);
        //EXIT ON CLICK
        btn2.setOnAction(e -> primaryStage.close());
        
        //DESIGN ELEMENTS
        gridPane.setStyle("-fx-background-color: linear-gradient(to bottom, #0000FF, #FFFF00);");


        // CREATING A SCENE
        Scene scene = new Scene(gridPane);
        //ADDING BACKGROUND COLOR
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
