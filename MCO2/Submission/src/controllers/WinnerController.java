package controllers;

import java.util.ArrayList;

import javafx.event.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.*;

/**
 * This class is a controller designed for ThatsLife! game, from CCPROG3 - DLSU CCS.
 * This controller controls the winner dialog, which simply displays the final ranking of players upon the game is completed.
 * @author Adriel Isaiah V. Amoguis
 *
 */
public class WinnerController implements EventHandler<Event> 
{
	/**
	 * This attribute holds the ordered list of player names according to rank.
	 */
	private ArrayList<String> results;
	
	/**
	 * This attribute holds the ordered list of double values that correspond to the players' balances.
	 * This follows the same order as the results ArrayList attribute.
	 */
	private double[] balances;
	
	/**
	 * This constructor instantiates this controller, tokenizes, and calculates for the rank String to be displayed in the view.
	 * @param ranking : String - the raw Ranking string given by the model
	 * @param balances : double[] - The list of balances of the players.
	 */
	public WinnerController(String ranking, double[] balances)
	{
		results = new ArrayList<String>();
		this.balances = balances;
		
		// Process Winnings
		
		// Split via double newline
		String[] rawRank = ranking.split("\n\n");
		
		// Strip the number and brackets
		for(int i = 0; i < rawRank.length; i++)
		{
			String temp = rawRank[i].substring("[x] ".length());
			temp = temp.split("\n")[0];
			temp = temp.substring(1, temp.length() - 2);
			rawRank[i] = new String(temp);
		}
		
		// Release results
		for(String rank : rawRank)
			this.results.add(rank);
		
	}
	
	// FXML
	@FXML AnchorPane firstPlace; @FXML Label labelFirstPlace;
	@FXML AnchorPane secondPlace; @FXML Label labelSecondPlace;
	@FXML AnchorPane thirdPlace; @FXML Label labelThirdPlace;
	@FXML Button mainMenu;
	
	/**
	 * This method initializes the JavaFX components on the stage with their appropriate values as given by the results of the game.
	 */
	@FXML
	void initialize()
	{
		// Process Winners and Colors
		ArrayList<Label> labels = new ArrayList<Label>();
		labels.add(labelFirstPlace);
		labels.add(labelSecondPlace);
		labels.add(labelThirdPlace);
		
		for(int i = 0; i < results.size(); i++)
		{
			Label label = labels.get(i);
			
			label.setText(String.format("[%d] %s", i+1, results.get(i)) + " | Balance = $" + balances[i]);
		}
		
		// Disable 3rd label if 2 players only
		if(results.size() < 3)
		{
			labelThirdPlace.setText("");
			labelThirdPlace.setDisable(true);
			thirdPlace.setDisable(true);
		}
	}

	/**
	 * This event handler redirects ActionEvents to the ActionEvent handler.
	 * @param ev : Event
	 */
	@Override
	public void handle(Event ev) 
	{
		if(ev instanceof ActionEvent)
			handle((ActionEvent)ev);
	}
	
	/**
	 * This ActionEvent handler handles the operations for the Exit Game button.
	 * @param ev : ActionEvent
	 */
	private void handle(ActionEvent ev)
	{
		if(ev.getSource() instanceof Button)
		{
			try
			{
				Stage primaryStage = (Stage) ((Button) ev.getSource()).getScene().getWindow();
				primaryStage.close();
				
				// Open new
				FXMLLoader newLoader = new FXMLLoader(getClass().getResource("/resources/MainMenu.fxml"));
				
				Parent root = newLoader.load();
				
				primaryStage = new Stage();
				primaryStage.setTitle("Main Menu - That's Life!");
				primaryStage.setResizable(false);
				primaryStage.setScene(new Scene(root));
				primaryStage.show();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
}
