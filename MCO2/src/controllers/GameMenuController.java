package controllers;

import thatslife.*;

import java.io.File;

import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.fxml.*;

/**
 * This class is a controller designed for ThatsLife! game, from CCPROG3 - DLSU CCS.
 * This controller controls the view for the game menu.
 * 
 * @author Adriel Isaiah V. Amoguis
 */
public class GameMenuController implements EventHandler<Event>
{
	/**
	 * This stores the instance of the game being played.
	 * This is used to save the game unto a serialized file.
	 */
	private ThatsLife gameInstance;
	
	/**
	 * The instance of the stage, to close or modify when necessary.
	 */
	private Stage primaryStage;
	
	@FXML Button saveGame;
	@FXML Button mainMenu;
	@FXML Button back;
	
	/**
	 * This constructor creates the controller instance.
	 * @param game : ThatsLife - the instance of the game to control
	 * @param primaryStage - The stage instance that the constructor belongs to.
	 */
	public GameMenuController(ThatsLife game, Stage primaryStage)
	{
		gameInstance = game;
		this.primaryStage = primaryStage;
	}
	
	/**
	 * This event handler redirects ActionEvents to the private ActionEvent handler, which then
	 * handles all button operations.
	 * @param ev : Event - the event to handle
	 */
	@Override
	public void handle(Event ev)
	{
		if(ev instanceof ActionEvent)
			handle((ActionEvent) ev);
	}
	
	/**
	 * The private event handler that handles all ActionEvents
	 * @param ev : ActionEvent
	 */
	private void handle(ActionEvent ev)
	{
		// Back Button
		if(((Button)ev.getSource()).getId().equals(back.getId()))
		{
			// Close this stage & window
			Stage menuStage = (Stage) ((Button) ev.getSource()).getScene().getWindow();
			menuStage.close();
		}
		
		// Main Menu Button
		if(((Button)ev.getSource()).getId().equals(mainMenu.getId()))
		{
			// Close this stage and create new stage for the main menu stage
			Stage menuStage = (Stage) ((Button) ev.getSource()).getScene().getWindow();
			menuStage.close();
			primaryStage.close();
			
			try 
			{
				Stage mainMenuStage = new Stage();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/MainMenu.fxml"));
				AnchorPane root = (AnchorPane) fxmlLoader.load();
				Scene scene = new Scene(root);
				
				mainMenuStage.setTitle("Main Menu - That's Life! (AMOGUIS - S13B)");
				mainMenuStage.setResizable(false);
				mainMenuStage.setScene(scene);
				mainMenuStage.show();
				
				ThatsLife.setSessionJFXController(null);
			} 
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		// Save Game Button
		if(((Button)ev.getSource()).getId().equals(saveGame.getId()))
		{
			// Open a file path dialog
			FileChooser fChooser = new FileChooser();
			fChooser.setTitle("Select your save game file");
			fChooser.getExtensionFilters().addAll(
					new ExtensionFilter("ThatsLife Save Game Files","*." + ThatsLife.FILEEXT),
					new ExtensionFilter("All Files","*.*")
			);
			File selectedDirectory = fChooser.showSaveDialog(saveGame.getScene().getWindow());
			
			if(selectedDirectory == null)
				return;
			
			// Save the Game
			ThatsLife.saveGame(gameInstance, selectedDirectory.getAbsolutePath());
		}
	}
}
