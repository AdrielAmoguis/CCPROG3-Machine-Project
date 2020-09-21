package controllers;

import thatslife.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;
import javafx.beans.property.StringProperty;
import javafx.beans.value.*;

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
		System.out.println("Game initialized");
	}
	
	@Override
	public void handle(Event ev) 
	{
		
	}
	
	public void handle(ActionEvent ev)
	{
		
	}

}
