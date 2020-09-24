package controllers;

import javafx.event.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;

public class MainController implements EventHandler<Event>
{	
	@FXML
	void initialize() {}
	
	@Override
	public void handle(Event e)
	{
		// Redirect buttons to the ActionEvent handler
		if(e.getSource() instanceof Button)
			handle((ActionEvent) e);
	}
	
	public void handle(ActionEvent e)
	{
		// Check for the button string
		String buttonText = ((Button) e.getSource()).getText();
		
		if(buttonText.equalsIgnoreCase("New Game"))
			newGame(e);
		else if(buttonText.equalsIgnoreCase("Load Saved Game"))
			loadGame(e);
		else if(buttonText.equalsIgnoreCase("options"))
			settings();
	}
	
	private void newGame(ActionEvent ev)
	{
		// Close current window and display new game window
		try
		{
			Stage currentStage = (Stage)((Button) ev.getSource()).getScene().getWindow();
			
			FXMLLoader newLoader = new FXMLLoader(getClass().getResource("/resources/NewGameMenu.fxml"));
			Parent root = newLoader.load();
			currentStage.setTitle("New Game - That's Life!");
			currentStage.setResizable(false);
			currentStage.setScene(new Scene(root));
			currentStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void loadGame(ActionEvent ev)
	{
		// Close current window and display load game window
		try
		{
			Stage currentStage = (Stage)((Button) ev.getSource()).getScene().getWindow();
			
			FXMLLoader newLoader = new FXMLLoader(getClass().getResource("/resources/LoadGameMenu.fxml"));
			Parent root = newLoader.load();
			currentStage.setTitle("Load Game - That's Life!");
			currentStage.setResizable(false);
			currentStage.setScene(new Scene(root));
			currentStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void settings()
	{
		
	}
}
