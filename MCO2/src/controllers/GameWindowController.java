package controllers;

import thatslife.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;
import javafx.beans.property.StringProperty;
import javafx.beans.value.*;
import javafx.scene.control.Alert.AlertType;

public class GameWindowController implements EventHandler<Event>
{
	private ThatsLife activeGame;
	
	
	public GameWindowController()
	{
		activeGame = null;
	}
	
	public void setActiveGame(ThatsLife game)
	{
		this.activeGame = game;
	}
	
	@FXML
	void initialize()
	{
		initializeGame();
	}
	
	private void initializeGame()
	{
		// Load visual elements to the JavaFX Window
		//System.out.println("Game initialized");
		//activeGame.setJFXController(this);
	}
	
	@Override
	public void handle(Event ev) 
	{
		
	}
	
	public void handle(ActionEvent ev)
	{
		
	}
	
	// CHOICE DIALOG
	public int displayDecision(String prompt, String[] choices)
	{
		int decision = -1;
		String selected = null;
		ChoiceDialog<String> choiceDialog = new ChoiceDialog<String>(choices[0], choices);
		choiceDialog.setContentText(prompt);
		choiceDialog.setHeaderText("Make a Decision - That's Life");
		
		try
		{
			// Show the dialog box
			choiceDialog.showAndWait();
			
			// Get the result
			selected = choiceDialog.getSelectedItem();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// Search for the selected item in the choices array to get index
		if(!selected.isEmpty())
		{
			boolean found = false;
			for(int i = 0; i < choices.length && !found; i++)
			{
				if(choices[i].equals(selected))
				{
					decision = i;
					found = true;
				}
			}
		}
		
		return decision;
	}
	
	// Prompt Box
}