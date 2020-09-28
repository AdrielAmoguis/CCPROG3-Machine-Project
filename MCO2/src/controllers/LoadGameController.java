package controllers;

import thatslife.ThatsLife;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.*;
import javafx.fxml.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.beans.value.*;

/**
 * This class is a controller designed for ThatsLife! game, from CCPROG3 - DLSU CCS.
 * This controller controls the view for the load game menu, which loads serialized instances of the game.
 * 
 * @author Adriel Isaiah V. Amoguis
 */
public class LoadGameController implements EventHandler<Event>, ChangeListener<String>
{
	/**
	 * This attribute holds the current selected file for loading.
	 */
	private File currentFile;
	
	@FXML
	TextField pathField;
	
	@FXML
	Button chooseFile;
	
	@FXML
	Button loadGame;
	
	@FXML
	Button backButton;
	
	/**
	 * This constructor sets default values to this instance's attributes.
	 */
	public LoadGameController()
	{
		currentFile = null;
	}
	
	/**
	 * This method initializes JavaFX components in the Stage.
	 */
	@FXML
	void initialize()
	{
		loadGame.setDisable(true);
		
		pathField.textProperty().addListener(this::changed);
	}

	/**
	 * This method redirects ActionEvents to the ActionEvent handler.
	 * @param ev : Event
	 */
	@Override
	public void handle(Event ev) 
	{
		if(ev instanceof ActionEvent)
			handle((ActionEvent) ev);
	}
	
	/**
	 * This event handler handles all action events in the stage.
	 * @param ev : ActionEvent to handle
	 */
	private void handle(ActionEvent ev)
	{
		if(ev.getSource() instanceof Button)
		{
			// Choose File Button
			if(((Button) ev.getSource()).getId().equals(chooseFile.getId()))
			{
				// Open a file path dialog
				FileChooser fChooser = new FileChooser();
				fChooser.setTitle("Select your save game file");
				fChooser.getExtensionFilters().addAll(
						new ExtensionFilter("ThatsLife Save Game Files","*." + ThatsLife.FILEEXT),
						new ExtensionFilter("All Files","*.*")
				);
				File selectedDirectory = fChooser.showOpenDialog(chooseFile.getScene().getWindow());
				pathField.setText(selectedDirectory.getAbsolutePath());
			}
			else if(((Button) ev.getSource()).getId().equals(loadGame.getId()))
			{
				// Read the file and deserialize
				ThatsLife loadedGame = null;
				try
				{
					loadedGame = ThatsLife.loadGame(this.pathField.getText());
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				// Open new window if game is not null
				if(loadedGame != null)
				{
					try
					{
						Stage currentStage = (Stage)((Button) ev.getSource()).getScene().getWindow();
						currentStage.close();
						
						FXMLLoader newLoader = new FXMLLoader(getClass().getResource("/resources/GameWindow.fxml"));
						GameWindowController cont = new GameWindowController(loadedGame);
						newLoader.setController(cont);
						
						// Set session controller
						ThatsLife.setSessionJFXController(cont);
						
						// Set card decks
						ThatsLife.setDeck(loadedGame.getDecks());
						
						Parent root = newLoader.load();
						
						currentStage = new Stage();
						currentStage.setTitle("Active Game - That's Life!");
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
			// Back Button
			if(((Button) ev.getSource()).getId().equals(backButton.getId()))
			{
				try
				{
					Stage currentStage = (Stage)((Button) ev.getSource()).getScene().getWindow();
					
					FXMLLoader newLoader = new FXMLLoader(getClass().getResource("/resources/MainMenu.fxml"));
					Parent root = newLoader.load();
					
					currentStage.setTitle("Main Menu - That's Life! (AMOGUIS - S13B)");
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
	}

	/**
	 * This method listens and handles for changes in the textbox in the JavaFX stage. It updates the the currentFile attribute.
	 * @param observed : ObservableValue given by the change caller.
	 * @param oldString : The old value of the textbox.
	 * @param newString : The new value of the textbox.
	 */
	@Override
	public void changed(ObservableValue<? extends String> observed, String oldString, String newString) 
	{
		try 
		{
			Path path = Paths.get(newString);
			this.currentFile = path.toFile();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(currentFile == null)
			loadGame.setDisable(true);
		else
			loadGame.setDisable(false);
	}
}
