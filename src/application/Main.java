/* Name: Emily Wing Lum Cheung, Class: CS 1B, Date: 7/27/2022, Instructor: Dave Harden,
 * Name of file: Main.java
 * 
 * This is a GUI program that guesses a number. It asks user to input a lower number and a higher number,
 * then the program will make a guess with the midpoint of that range. For each guess, the user will 
 * need to respond "lower", "higher" if the guess does not match the user's number. If the guess
 * matches, the user will respond "correct".
 * */

package application;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Main extends Application {
	
	private VBox mainVBox;
	private TextField start;
	private TextField end;
	private Label guess;
	private Label btnInstruction;
	private int lo;
	private int hi;
	private int mid;
	private Button okButton;
	private Button lower;
	private Button higher;
	private Button correct;
	
	//Initial setup of the program and ask user to enter the two numbers

    public void start(Stage applicationStage) {
        mainVBox = new VBox();
        
        Label rangeInstruction = new Label("Enter the range of numbers for guessing");
        mainVBox.getChildren().add(rangeInstruction);
        
        start = new TextField();
        start.setText("low number");
        start.setEditable(true);
        end = new TextField();
        end.setText("high number");
        end.setEditable(true);

        okButton = new Button("OK");
        okButton.setOnAction(this::handleOk);

        HBox range = new HBox(start, end, okButton);
        range.setPadding(new Insets(2, 0, 0, 2));
        range.setSpacing(5);
        mainVBox.getChildren().add(range);
        
        mainVBox.setSpacing(20);
        mainVBox.setAlignment(Pos.TOP_LEFT);
        mainVBox.setPadding(new Insets(15, 0, 0, 15));
        
        guess = new Label();
        btnInstruction = new Label();
        
        lower = new Button("Lower");
    	lower.setOnAction(this::handleLower);
    	correct = new Button("Correct");
    	correct.setOnAction(this::handleCorrect);
    	higher = new Button("Higher");
    	higher.setOnAction(this::handleHigher);
        
        
        Scene scene = new Scene(mainVBox, 400, 400);

        applicationStage.setScene(scene);
        applicationStage.setTitle("Guessing Game"); 
        applicationStage.show(); 
    }
    
    //The method handles the "OK" button and displays the instructions about which button to click
    
    private void handleOk(ActionEvent event) {
    	
    	lo = Integer.parseInt(start.getText());
    	hi = Integer.parseInt(end.getText());
    	
    	mid = (lo+hi)/2;
    	
    	guess.setText("My guess is " + mid);
    	mainVBox.getChildren().add(guess);
    	
    	btnInstruction.setText("Click 'Lower' if your number is lower,\n'Higher' if it is higher,\n'Correct' if it is correct.\n");
    	mainVBox.getChildren().add(btnInstruction);
	
    	HBox threeBtns = new HBox(lower, correct, higher);
    	threeBtns.setSpacing(10);
    	
    	mainVBox.getChildren().add(threeBtns);

    }

    //This method handles the "lower" button to make the next guess
    
    private void handleLower(ActionEvent event) {
    	if (mid <= 0) {
    		hi = mid - 1;
    	}
    	else if (mid > 0) {
    		hi = mid;
    	}
    	mid = (lo+hi)/2;
    	
    	guess.setText("My guess is " + mid);
    }
    
    //This method handles the "higher" button to make the next guess
    
    private void handleHigher(ActionEvent event) {
    	if (mid <= 0) {
    		lo = mid;
    	}
    	else if (mid > 0) {
    		lo = mid + 1;
    	}
    	mid = (lo+hi)/2;
    	
    	guess.setText("My guess is " + mid);
    	
    }
    
    //This method handles the correct button and disables all buttons
   
    private void handleCorrect(ActionEvent event) {
    	guess.setText("Your number was " + mid + "!!");
    	okButton.setDisable(true);
    	lower.setDisable(true);
    	correct.setDisable(true);
    	higher.setDisable(true);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}