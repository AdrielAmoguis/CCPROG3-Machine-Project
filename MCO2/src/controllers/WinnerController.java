package controllers;

import java.util.ArrayList;

import javafx.event.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.*;

public class WinnerController implements EventHandler<Event> 
{
	private ArrayList<String> results;
	private double[] balances;
	
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

	@Override
	public void handle(Event ev) 
	{
		if(ev instanceof ActionEvent)
			handle((ActionEvent)ev);
	}
	
	private void handle(ActionEvent ev)
	{
		if(ev.getSource() instanceof Button)
		{
			try
			{
				Stage primaryStage = (Stage) ((Button) ev.getSource()).getScene().getWindow();
				primaryStage.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
}
