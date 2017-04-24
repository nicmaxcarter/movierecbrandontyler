package dbfinal;

import java.util.ArrayList;

/*Artist: Tyler Cabutto; Brandon Little */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent>{
	/*Button q1;
	Button q2;
	Button q3;
	Button q4;
	Button q5;
	Button q6;
	Button q7;
	Button q8;
	Button q9;
	Button q10;
	Button clear;*/
	String q;
	TextField t1;	
	TextField id;
	TextField recField;
	Label output;
	Label title;
	Label info;
	Label recMe;
	Button search;
	Button show;
	Button recDo;
	ComboBox<String> select;
	ComboBox<String> howMany;
	ComboBox<String> rec;
	ImageView iv1;
	ImageView iv2;
	
	ArrayList<String> query;
	
	public static void main(String[] args){
		launch();
	}
	
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("Movie Recommender 3000");
		VBox layout = new VBox();
		HBox menu = new HBox();
		Label space = new Label();
		ScrollPane scroll = new ScrollPane();
		scroll.setMinHeight(350);
		HBox picMenu = new HBox();
		HBox recMenu = new HBox();
		
		//directions at the top
		title = new Label();
		title.setText("Search By:");
		title.setStyle("-fx-font: 24 arial;");
		
		
		//select what type of information to show
		select = new ComboBox<String>();
		select.getItems().addAll("Top Movies", "Movie Title", "Genre", "Director", "Actor", "Movies with tag", "Top Directors", "Top Actors", "Ratings by Id", "Movie Tags");
		select.setMinWidth(150);
		select.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e)
			{
				handleComboBoxAction();
			}
		});
		
		//Select how many items to show
		howMany = new ComboBox<String>();
		howMany.getItems().addAll("10", "20", "50");
		howMany.setMinWidth(70);
		howMany.setMaxWidth(70);
		howMany.setVisible(false);
		
		//Search button
		search = new Button();
		search.setText("Search");
		search.setMinWidth(70);
		search.setMaxWidth(70);
		search.setOnAction(this);
		
		//text area for user input
		t1 = new TextField();		
		t1.setPrefWidth(750);
		t1.setVisible(false);	
		
		//shows query output
		output = new Label();
		output.setStyle("-fx-font-family: monospace");
        output.setWrapText(false);
		
		//tells user to input id
		info = new Label();
		info.setText("Input the movie number to see its picture: ");
		info.setStyle("-fx-font: 20 arial;");
		
		//reads in 
		id = new TextField();
		id.setPrefWidth(177);
		
		//show button to display images
		show = new Button();
		show.setText("Show Me the Pictures!");
		show.setMinWidth(250);
		show.setOnAction(this);
		
		//recommendation label
		recMe = new Label();
		recMe.setText("Let us recommend some movies: ");
		recMe.setStyle("-fx-font: 24 arial;");
		
		//recommendation combobox
		rec = new ComboBox<String>();
		rec.getItems().addAll("Genre", "Director");
		rec.setMinWidth(100);
		
		//recommendation input
		recField = new TextField();
		recField.setPrefWidth(700);
		
		//recommendation button
		recDo = new Button();
		recDo.setText("Show me some movies!");
		recDo.setMinWidth(250);
		recDo.setOnAction(this);
		
		
		//construct the view
		scroll.setContent(output);
		menu.getChildren().addAll(select, t1, howMany, search);
		picMenu.getChildren().addAll(info, id, show);
		recMenu.getChildren().addAll(rec, recField, recDo);
		layout.getChildren().addAll(title, menu, scroll, picMenu, space, recMe, recMenu);
		Scene scene = new Scene(layout, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void handle(ActionEvent event) {
		String s = "";
		String in;
		
		//onclick for search
		if(select.getSelectionModel().getSelectedItem() != null){
			s = select.getSelectionModel().getSelectedItem();
		}
		if(s.equals("Top Movies")){
			in = howMany.getSelectionModel().getSelectedItem();
			q = QueryTester.query1(in);
			output.setText(q);
		}
		if(s.equals("Movie Title")){
			in = t1.getText();
			q = QueryTester.query2(in);
			output.setText(q);
		}
		if(s.equals("Genre")){
			in = t1.getText();
			int i = Integer.parseInt(howMany.getSelectionModel().getSelectedItem());
			q = QueryTester.query3(in, i);
			output.setText(q);
		}
		if(s.equals("Director")){
			in = t1.getText();
			q = QueryTester.query4(in);
			output.setText(q);
		}
		if(s.equals("Actor")){
			in = t1.getText();
			q = QueryTester.query5(in);
			output.setText(q);
		}
		if(s.equals("Movies with tag")){
			in = t1.getText();
			q = QueryTester.query6(in);
			output.setText(q);
		}
		if(s.equals("Top Directors")){
			in = t1.getText();
			q = QueryTester.query7(in);
			output.setText(q);
		}
		if(s.equals("Top Actors")){
			in = t1.getText();
			q = QueryTester.query8(in);
			output.setText(q);
		}
		if(s.equals("Ratings by Id")){
			in = t1.getText();
			q = QueryTester.query9(in);
			output.setText(q);
		}
		if(s.equals("Movie Tags")){
			in = t1.getText();
			q = QueryTester.query10(in);
			output.setText(q);
		}
		
		//onclick of recommendation
		if(rec.getSelectionModel().getSelectedItem() != null){
			s = rec.getSelectionModel().getSelectedItem();
		}
		if(event.getSource() == recDo){
			if(s.equals("Genre")){
				in = recField.getText();
				q = QueryTester.query11(in);
				output.setText(q);
			}
			if(s.equals("Director")){
				in = recField.getText();
				q = QueryTester.query12(in);
				output.setText(q);
			}
		}
		//onclick for showing pictures
		if(event.getSource() == show){
	        try {
	        	//take user input and get the index
	        	int i = 0;
	        	if(!id.getText().equals("")){
	        		i = Integer.parseInt(id.getText());
	        		System.out.println(i);
	        		i = i*2-2;
	        		System.out.println(i);
	        		System.out.println(query.size());
		        	String image1 = "http://" + query.get(i);
		        	String image2 = "http://" + query.get(i+1);
		        	System.out.println(query.get(i));
		        	System.out.println(query.get(i+1));
		        	HBox h = new HBox();
		        	
		        	//create the images
		    		iv1 = ImageViewBuilder.create().image(new Image(image1)).build();
		    		iv1.setFitWidth(225);
		    		iv1.setPreserveRatio(true);
		    		iv2 = ImageViewBuilder.create().image(new Image(image2)).build();
		    		iv2.setFitWidth(225);
		    		iv2.setPreserveRatio(true);
		    		
		    		h.getChildren().addAll(iv1, iv2);
		            Stage stage = new Stage();
		            stage.setTitle("Movie Images");
		            stage.setScene(new Scene(h, 450, 450));
		            stage.show();
	        	}
	        	
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		if(!s.equals("")){
			grabURL(q);
		}
		
	}
	
	public void handleComboBoxAction(){
		String s = select.getSelectionModel().getSelectedItem();
		if(s.equals("Top Movies")){
			t1.setVisible(false);
			howMany.setVisible(true);
			title.setText("Search by:\tselect how many movies you want to see:");
		}
		if(s.equals("Movie Title")){
			howMany.setVisible(false);
			t1.setVisible(true);
			title.setText("Search by:\tinput what movie you want to see:");
		}
		if(s.equals("Genre")){
			howMany.setVisible(true);
			t1.setVisible(true);
			title.setText("Search by:\tinput the genre you are searching for:");
		}
		if(s.equals("Director")){
			howMany.setVisible(false);
			t1.setVisible(true);
			title.setText("Search by:\tinput the director you are searching for:");
		}
		if(s.equals("Actor")){
			howMany.setVisible(false);
			t1.setVisible(true);
			title.setText("Search by:\tinput the actor you are searching for:");
		}
		if(s.equals("Movies with tag")){
			howMany.setVisible(false);
			t1.setVisible(true);
			title.setText("Search by:\tinput the tag you are searching for:");
		}
		if(s.equals("Top Directors")){
			t1.setVisible(true);
			howMany.setVisible(false);
			title.setText("Search by:\tinput the required number of movies directed:");
		}
		if(s.equals("Top Actors")){
			howMany.setVisible(false);
			t1.setVisible(true);
			title.setText("Search by:\tinput the required number of movies starred in:");
		}
		if(s.equals("Ratings by Id")){
			howMany.setVisible(false);
			t1.setVisible(true);
			title.setText("Search by:\tinput the Id of the user you are searching for:");
		}
		if(s.equals("Movie Tags")){
			howMany.setVisible(false);
			t1.setVisible(true);
			title.setText("Search by:\tinput the movie you want to see the tags for:");
		}
	}
	
	private ArrayList<String> grabURL(String in)
	{
		query = new ArrayList<String>();
		String[] vals = in.split(" ");
		String t = "";
		int i = 0;
		int j = 0;
		for(String s : vals)
		{
			if(s.length()>7)
			{	
				t = s.substring(0, 7);
				if(t.equals("http://"))
				{
					String sub = s.substring(7, s.length()-1);
					
					//first url
					if(j == 0){
						if(!sub.contains("flixster") && !sub.contains("rottentomatoes")){
							query.add("placeholder");
							j = 1;
						}
						query.add(sub);
					}
					
					//second url
					else {
						if(!sub.contains("ia.media")){
							query.add("placeholder");
							j = 0;
						}
						query.add(sub);
					}
					
					//increment
					i++;
					if(j == 0){
						j = 1;
					}
					else {
						j = 0;
					}
				}
			}
		}
		return query;
	}

/*	@Override
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
		

	} */


/*	public void handle(ActionEvent event){
		String in = "";
		if (event.getSource() == q1) {
			in = t1.getText();
			output.setText(QueryTester.query1(in));
		}
		if (event.getSource() == q2) {
			in = t1.getText();
			output.setText(QueryTester.query2(in));
		}
		if (event.getSource() == q3) {
			in = t1.getText();
			String[] s = in.split(" ");
			int i = Integer.parseInt(s[1]);
			output.setText(QueryTester.query3(s[0], i));
		}
		if (event.getSource() == q4) {
			in = t1.getText();
			output.setText(QueryTester.query4(in));
		}
		if (event.getSource() == q5) {
			in = t1.getText();
			output.setText(QueryTester.query5(in));
		}
		if (event.getSource() == q6) {
			in = t1.getText();
			output.setText(QueryTester.query6(in));
		}
		if (event.getSource() == q7) {
			in = t1.getText();
			output.setText(QueryTester.query7(in));
		}
		if (event.getSource() == q8) {
			in = t1.getText();
			output.setText(QueryTester.query8(in));
		}
		if (event.getSource() == q9) {
			in = t1.getText();
			output.setText(QueryTester.query9(in));
		}
		if (event.getSource() == q10) {
			in = t1.getText();
			output.setText(QueryTester.query10(in));
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
*/

	
}
