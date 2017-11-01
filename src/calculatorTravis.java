import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class calculatorTravis extends Application{

    TextField num1box, num2box;
    Button addbtn, subbtn, clearbtn;
    Label solutionlbl;

    @Override
    public void start(Stage stage) throws Exception {
        //Make buttons
        num1box = new TextField();
        num2box = new TextField();
        addbtn = new Button("+");
        subbtn = new Button("-");
        clearbtn = new Button("AC");
        solutionlbl = new Label("Enter two integers, then click on an operation.");
        solutionlbl.setStyle("-fx-border-color: #000; -fx-padding: 10px;");
        solutionlbl.setAlignment(Pos.CENTER);
        stage.setTitle("Calculator");

        //Make Calculator Container
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);

        //Set space between buttons
        root.setHgap(10);
        root.setVgap(10);

        //add buttons
        root.add(addbtn, 2, 0);
        root.add(subbtn, 2, 1);
        root.add(clearbtn, 3, 0);
        root.add(num1box, 0, 0);
        root.add(num2box, 0, 1);
        root.add(solutionlbl, 0, 3);
        Scene scene = new Scene(root, 800, 250);

        //set widths
        addbtn.setPrefWidth(80);
        subbtn.setPrefWidth(80);
        clearbtn.setPrefWidth(80);

        attachAction();

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }
    public void attachAction() {
        addbtn.setOnAction(x->btnAction(x));
        subbtn.setOnAction(x->btnAction(x));
        clearbtn.setOnAction(x->btnAction(x));
    }

    public void btnAction(ActionEvent x) {
        int num1, num2, solution;
        String operation;

        if(x.getSource() == clearbtn) {
            num1box.setText("");
            num2box.setText("");
            solutionlbl.setText("Enter two integers, then click on an operation.");
            num1box.requestFocus();
            return;
        }
        num1 = Integer.parseInt(num1box.getText());
        num2 = Integer.parseInt(num2box.getText());
        if(x.getSource() == addbtn) {
            Addition add = new Addition(num1, num2);
            add.evaluate(num1, num2);
        }
        else{
            Subtraction sub = new Subtraction(num1, num2);
            sub.evaluate(num1, num2);
        }
        // solutionlbl.setText("Result: " + num1 + operation + num2 + " = " + solution);

    }

    public static void main(String[] args) {
        launch(args);
    }

    public abstract class MathOpp{
        double x, y;
        public MathOpp(int x, int y){
            this.x = x;
            this.y = y;
        }

        public abstract void evaluate(int x, int y);
    }


    public class Addition extends MathOpp{
        public Addition(int x, int y) {
            super(x, y);
        }

        @Override
        public void evaluate(int x, int y) {
            String operation = " + ";
            int solution = x + y;
            solutionlbl.setText("Result: " + x + operation + y + " = " + solution);
        }
    }

    public class Subtraction extends MathOpp{
        public Subtraction(int x, int y) {
            super(x, y);
        }

        @Override
        public void evaluate(int x, int y) {
            String operation = " - ";
            int solution = x - y;
            solutionlbl.setText("Result: " + x + operation + y + " = " + solution);

        }
    }
}

/**
 public void attachAction() {
 addbtn.setOnAction(x->btnAction(x));
 subbtn.setOnAction(x->btnAction(x));
 clearbtn.setOnAction(x->btnAction(x));
 }

 public void btnAction(ActionEvent x) {
 int num1, num2, solution;
 String operation;

 if(x.getSource() == clearbtn) {
 num1box.setText("");
 num2box.setText("");
 solutionlbl.setText("Enter two integers, then click on an operation.");
 num1box.requestFocus();
 return;
 }
 num1 = Integer.parseInt(num1box.getText());
 num2 = Integer.parseInt(num2box.getText());
 if(x.getSource() == addbtn) {
 operation = " + ";
 solution = num1 + num2;
 }
 else{
 operation = " - ";
 solution = num1 - num2;
 }
 solutionlbl.setText("Result: " + num1 + operation + num2 + " = " + solution);
 }**/