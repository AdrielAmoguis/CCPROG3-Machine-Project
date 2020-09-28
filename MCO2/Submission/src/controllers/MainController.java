package controllers;

import javafx.event.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;

/**
 * This class is a controller designed for ThatsLife! game, from CCPROG3 - DLSU CCS.
 * This is the main JavaFX controller for the GUIMain class.
 * @author Adriel Isaiah V. Amoguis
 *
 */
public class MainController implements EventHandler<Event>
{	
	/**
	 * Empty implementation of the FXML initialize() method.
	 */
	@FXML
	void initialize() {}
	
	/**
	 * This method redirects ActionEventst to the ActionEvent handler.
	 * @param e : Event
	 */
	@Override
	public void handle(Event e)
	{
		// Redirect buttons to the ActionEvent handler
		if(e.getSource() instanceof Button)
			handle((ActionEvent) e);
	}
	
	/**
	 * This method handles the ActionEvents given by the buttons.
	 * @param e : The ActionEvent to handle
	 */
	private void handle(ActionEvent e)
	{
		// Check for the button string
		String buttonText = ((Button) e.getSource()).getText();
		
		if(buttonText.equalsIgnoreCase("New Game"))
			newGame(e);
		else if(buttonText.equalsIgnoreCase("Load Saved Game"))
			loadGame(e);
		else if(buttonText.equalsIgnoreCase("options"))
			settings(e);
	}
	
	/**
	 * Method to be called when ActionEvent is the new game button.
	 * @param ev : A copy of the instance of the action event. This is used to get the stage.
	 */
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
	
	/**
	 * Method to be called when ActionEvent is the load game button.
	 * @param ev : A copy of the instance of the action event. This is used to get the stage.
	 */
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
	
	/**
	 * Method to be called when ActionEvent is the settings button.
	 * @param ev : A copy of the instance of the action event. This is used to get the stage.
	 */
	private void settings(ActionEvent ev)
	{
		// Close current window and display load game window
		try
		{
			Stage currentStage = (Stage)((Button) ev.getSource()).getScene().getWindow();
			
			FXMLLoader newLoader = new FXMLLoader(getClass().getResource("/resources/Options.fxml"));
			Parent root = newLoader.load();
			currentStage.setTitle("Settings - That's Life!");
			currentStage.setResizable(false);
			currentStage.setScene(new Scene(root));
			currentStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
