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

public class GameMenuController implements EventHandler<Event>
{
	private ThatsLife gameInstance;
	private Stage primaryStage;
	
	@FXML Button saveGame;
	@FXML Button mainMenu;
	@FXML Button back;
	
	public GameMenuController(ThatsLife game, Stage primaryStage)
	{
		gameInstance = game;
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void handle(Event ev)
	{
		if(ev instanceof ActionEvent)
			handle((ActionEvent) ev);
	}
	
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
