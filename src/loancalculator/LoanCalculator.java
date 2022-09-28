
package loancalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class LoanCalculator extends Application {
    TextField tFAnnualInterestRate = new TextField();
    Label lAnnualInterestRate= new Label();
    GridPane gridPane = new GridPane();
    Scene scene;
    
    @Override
    public void start(Stage stage) {
        
        //Settings label
        lAnnualInterestRate.setText("Annual Interest Rate");
        
        
        //     0  1  2  3  4  5
        //  0  
        //  1
        //  2
        //  3
        //  4
        
        //Setting gridPane
        gridPane.setHgap(5); // value horizontal 
        gridPane.setVgap(5); // value vertical 
        gridPane.add(lAnnualInterestRate, 0, 0);
        gridPane.add(tFAnnualInterestRate, 1, 0);       // Add text field to grid pane 
       
 
        stage.setTitle("Loan Calculator!");
        scene= new Scene(gridPane,400,300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
