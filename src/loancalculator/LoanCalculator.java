
package loancalculator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class LoanCalculator extends Application {
    //TextFields (write)
    TextField tFAnnualInterestRate = new TextField();
    TextField tFNumberOfYears = new TextField();
    TextField tFLoanAmount = new TextField();
    TextField tFMonthlyPayment = new TextField();
    TextField tFTotalPayment = new TextField();
    
    //Labels (just text)
    Label lAnnualInterestRate= new Label();
    Label lNumberOfYears= new Label();
    Label lLoanAmount= new Label();
    Label lMonthlyPayment=new Label();
    Label lTotalPayment=new Label();
    
    //Buttons
    Button button = new Button();
    
    //GridPane
    GridPane gridPane = new GridPane();
    
    //StackPane
    StackPane stackPane= new StackPane();
    Scene scene;
    
    @Override
    public void start(Stage stage) {
        
      
        //Settings label
        lAnnualInterestRate.setText("Annual Interest Rate:");
        lNumberOfYears.setText("Number of Years");
        lLoanAmount.setText("Loan Amount:");
        lMonthlyPayment.setText("Monthly Payment:");
        lTotalPayment.setText("Total Payment:");
        
        //Settings textFields
        tFMonthlyPayment.setEditable(false);
        tFTotalPayment.setEditable(false);
        
        //Settings button
        button.setText("Calculate");
        
        
        //     0  1  
        //  0  
        //  1
        //  2
        //  3
        //  4
        
        //Setting pane
        stackPane.getChildren().add(button);
        stackPane.setAlignment(Pos.BASELINE_RIGHT);
        
        //Setting gridPane
        gridPane.setHgap(2); // value horizontal 
        gridPane.setVgap(5); // value vertical 
        
        gridPane.add(lAnnualInterestRate, 0, 0);
        gridPane.add(tFAnnualInterestRate, 1, 0);  
        
        gridPane.add(lNumberOfYears, 0, 1);
        gridPane.add(tFNumberOfYears, 1, 1);
        
        gridPane.add(lLoanAmount, 0, 2);
        gridPane.add(tFLoanAmount,1, 2);
        
        gridPane.add(lMonthlyPayment, 0, 3);
        gridPane.add(tFMonthlyPayment, 1, 3);
        
        gridPane.add(lTotalPayment, 0, 4);
        gridPane.add(tFTotalPayment, 1, 4);
        
        gridPane.add(stackPane, 1, 5);  
        gridPane.setAlignment(Pos.CENTER);
        
        //Handlers
        tFLoanAmount.setOnAction(e->Calculate());
        button.setOnAction(e -> {Calculate();});
        
        // Stage settings
        stage.setTitle("Loan Calculator");
        scene= new Scene(gridPane,400,300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    private void Calculate() {
        double monthlyPayment;//Monthly payment
        double totalPayment; //Total payment
        double i=Double.parseDouble(tFAnnualInterestRate.getText()); // Annual interest rate
        double h=Double.parseDouble(tFLoanAmount.getText()); // Loan amount
        double r= i/(100*12); // r
        double n=Double.parseDouble(tFNumberOfYears.getText()); // years
        
        //Monthly payment calculate
        monthlyPayment = (h *r) / (1 - (Math.pow(1 + r, -12*n)));
        
        //Total payment
        totalPayment= monthlyPayment*n*12;
        
        //Round 2 decimal
        monthlyPayment= Math.round(monthlyPayment*100.0)/100.0;
        totalPayment=Math.round(totalPayment*100.0)/100.0;
        
        //Set textField with the result
        tFMonthlyPayment.setText(Double.toString(monthlyPayment));
        tFTotalPayment.setText(Double.toString(totalPayment));

    }

    
}
