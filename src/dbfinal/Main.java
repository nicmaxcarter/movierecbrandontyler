package dbfinal;

import java.util.ArrayList;

/*Artist: Tyler Cabutto; Brandon Little */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent>{
	Button q1;
	Button q2;
	Button q3;
	Button q4;
	Button q5;
	Button q6;
	Button q7;
	Button q8;
	Button q9;
	Button q10;
	Button clear;
	TextField t1;	
	Label output;
	
	ArrayList<String> query;
	
	public static void main(String[] args){
		launch();

		

		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Movie Recommender 3000");
		BorderPane layout = new BorderPane();
		HBox bRow = new HBox();
		bRow.setPadding(new Insets(1, 1, 1, 1));
		bRow.setSpacing(5);
		bRow.setStyle("-fx-background-color:  #5eb74e");
		
		q1 = new Button();
		q1.setText("Query 1");
		q1.setOnAction(this);
		
		q2 = new Button();
		q2.setText("Query 2");	
		q2.setOnAction(this);
		
		q3 = new Button();
		q3.setText("Query 3");
		q3.setOnAction(this);
		
		q4 = new Button();
		q4.setText("Query 4");
		q4.setOnAction(this);
		
		q5 = new Button();
		q5.setText("Query 5");	
		q5.setOnAction(this);
		
		q6 = new Button();
		q6.setText("Query 6");	
		q6.setOnAction(this);
		
		q7 = new Button();
		q7.setText("Query 7");	
		q7.setOnAction(this);
		
		q8 = new Button();
		q8.setText("Query 8");		
		q8.setOnAction(this);
		
		q9 = new Button();
		q9.setText("Query 9");		
		q9.setOnAction(this);
		
		q10 = new Button();
		q10.setText("Query 10");
		q10.setOnAction(this);
		
		bRow.getChildren().addAll(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10);
		
		
		t1 = new TextField();		
		t1.setPrefWidth(710);
		ScrollPane scroll = new ScrollPane();
		output = new Label();
//		output.setPrefHeight(1000);
		output.setText(menu());

		VBox vert = new VBox();
//		vert.autosize();
		output.autosize();
		vert.getChildren().add(output);
		scroll.setContent(vert);
		HBox bottom = new HBox();
		clear = new Button();
		clear.setText("Clear");	
		clear.setOnAction(this);
		bottom.getChildren().addAll(t1, clear);
		
		
		layout.setTop(bRow);
		layout.setBottom(bottom);
		layout.setCenter(scroll);
		
		Scene scene = new Scene(layout, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}

	private Object setAlignment(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public void handle(ActionEvent event){
		String in = "";
		if (event.getSource() == q1) {
			in = t1.getText();
                        output.setText("Test");
			output.setText(QueryTester.query1(in));
			
		}
		if (event.getSource() == q2) {
			
		}
		if (event.getSource() == q3) {
			
		}
		if (event.getSource() == q4) {
			
		}
		if (event.getSource() == q5) {
			
		}
		if (event.getSource() == q6) {
			
		}
		if (event.getSource() == q7) {
			
		}
		if (event.getSource() == q8) {
			
		}
		if (event.getSource() == q9) {
			
		}
		if (event.getSource() == q10) {
			
		}
		if(event.getSource() == clear) {
			t1.clear();
			output.setText(menu());
		}
	}
	
	private String menu()
	{
		return "********** Movie Recommender 3000 **********\n" +
                "Q1:  Show the top k movies based on scores.\n\t\tInput: how many movies?\n"+
                "Q2:  Given movie title, show its info and all tags related to it.\n\t\tInput: Movie title?\n"+
                "Q3:  Given genre and k, show top k movies of given genre based on RT scores. \n\t\tInput: Genre and how many movies?\n"+
                "Q4:  For any director name specified by user, show all the movies directed. \n\t\tInput: Director name?\n"+
                "Q5:  Given an actor, show his movies. \n\t\tInput: Actor name?\n"+
                "Q6:  For given tag, show all movies relating to that tag. \n\t\tInput: tag?\n"+
                "Q7:  Input a limit to see top directors. Must have at least k movies. \n\t\tInput: How many movies?\n"+
                "Q8:  Returns the top 10 actors with the highest average scores. Must have at least k movies. \n\t\tInput: How many movies?\n"+
                "Q9:  Show timeline of user rating by genre. \n\t\tInput: What is the user id?\n"+
                "Q10: See all tags for specified movie. \n\t\tInput: Movie title?";
	}
	
}