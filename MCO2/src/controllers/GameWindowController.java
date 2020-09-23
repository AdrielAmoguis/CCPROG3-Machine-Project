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
	
	@FXML
	TextArea messagePrompt;
	
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
		ThatsLife.setSessionJFXController(this);
		
		// Display Preliminary Messages
		this.displayPrompt("Game Started!");
		displayAlert("Welcome! - That's Life!", "Game Started!", "Have fun!", true);
		
		// Load visual elements to the JavaFX Window
		
	}
	
	@Override
	public void handle(Event ev) 
	{
		if(ev instanceof ActionEvent)
			handle((ActionEvent) ev);
	}
	
	private void handle(ActionEvent ev)
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
	public void displayPrompt(String prompt)
	{
		if(prompt != null)
			if(!prompt.isEmpty())
			{
				String existingText = new String(messagePrompt.getText());
				
				existingText += "\n";
				existingText += prompt;
				
				messagePrompt.setText(existingText);
			}
	}
	
	
	// Alert Box
	public void displayAlert(String title, String header, String prompt, boolean willWait)
	{
		Alert aBox = new Alert(Alert.AlertType.INFORMATION);
		
		aBox.setContentText(prompt);
		aBox.setTitle(title);
		aBox.setHeaderText(header);
		
		if(willWait)
			aBox.showAndWait();
		else
			aBox.show();
	}
}