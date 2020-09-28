package controllers;

import thatslife.ThatsLife;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;
import javafx.beans.property.StringProperty;
import javafx.beans.value.*;
import java.util.ArrayList;

/**
 * This class is a controller designed for ThatsLife! game, from CCPROG3 - DLSU CCS.
 * This controller controls the view for creating a brand new instance of a game.
 * @author Adriel Isaiah V. Amoguis
 *
 */
public class NewGameController implements EventHandler<Event>, ChangeListener<String>
{
	/**
	 * This attribute holds the instance of the JavaFX combobox component.
	 */
	private String comboState;
	
	/**
	 * This attribute holds the number of players that the combobox is selected to.
	 */
	private int nPlayers;
	
	/**
	 * This attribute holds all the player names entered by the JavaFX textbox component.
	 */
	private String[] playerNames;
	
	/**
	 * This constructor creates an instance of this controller and sets all attributes to their default values.
	 */
	public NewGameController()
	{
		comboState = null;
		nPlayers = 0;
		
		playerNames = new String[3];
		playerNames[0] = new String();
		playerNames[1] = new String();
		playerNames[2] = new String();
	}
	
	@FXML
	ComboBox<String> playerCombo;
	
	@FXML
	TextField playerOneName;
	
	@FXML
	TextField playerTwoName;
	
	@FXML
	TextField playerThreeName;
	
	@FXML
	Button createGame;
	
	@FXML
	Button backButton;
	
	/**
	 * This method initializes all JavaFX components that need to be initialized.
	 */
	@FXML
	void initialize()
	{
		playerCombo.setOnAction(this::handle);
		playerCombo.getItems().clear();
		playerCombo.getItems().addAll("2 Players", "3 Players");
		
		createGame.setOnAction(this::handle);
		createGame.setDisable(true);
		
		playerOneName.textProperty().addListener(this::changed);
		playerTwoName.textProperty().addListener(this::changed);
		playerThreeName.textProperty().addListener(this::changed);
		
		playerOneName.setDisable(true);
		playerTwoName.setDisable(true);
		playerThreeName.setDisable(true);
	}

	/**
	 * This method redirects all ActionEvent to the ActionEvent handler.
	 * @param ev : Event
	 */
	@Override
	public void handle(Event ev)
	{
		if(ev instanceof ActionEvent)
			handle((ActionEvent) ev);
	}
	
	/**
	 * This method is the event handler for all ActionEvents such as buttons in the Stage.
	 * @param ev : ActionEvent - ActionEvent to handle.
	 */
	private void handle(ActionEvent ev)
	{
		if(ev.getSource() instanceof ComboBox)
		{
			// Update players
			ComboBox<?> box = ((ComboBox<?>) ev.getSource());
			this.comboState = ((String)box.getValue());
			
			if(this.comboState.equals("2 Players"))
				nPlayers = 2;
			else if(this.comboState.equals("3 Players"))
				nPlayers = 3;
			else
				nPlayers = 0;
			
			if(nPlayers != 0)
			{
				// Open the TextFields
				playerOneName.setDisable(false);
				switch(nPlayers)
				{
					case 3: playerThreeName.setDisable(false);
					case 2: playerTwoName.setDisable(false);
						if(nPlayers == 2)
							playerThreeName.setDisable(true);
				}
			}
		}
		else if(ev.getSource() instanceof Button)
		{
			if(((Button)ev.getSource()).getId().equals(createGame.getId()))
			{
				// Pass the number of players to the next controller for the next window
				try
				{
					Stage currentStage = (Stage)((Button) ev.getSource()).getScene().getWindow();
					currentStage.close();
					
					FXMLLoader newLoader = new FXMLLoader(getClass().getResource("/resources/GameWindow.fxml"));
					
					// Create game instance
					ArrayList<String> names = new ArrayList<String>();
					for(int i = 0; i < nPlayers; i++)
						names.add(playerNames[i]);
					
					ThatsLife.setSessionJFXController(null);
					
					newLoader.setController(new GameWindowController(new ThatsLife(names)));
					
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
			else if(((Button)ev.getSource()).getId().equals(backButton.getId()))
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
	 * This change listener detects changes in the text boxes and updates the player names accordingly.
	 * @param observable - The object that changed.
	 * @param oldString - The old value of the object.
	 * @param newString - The new value of the object.
	 */
	@Override
	public void changed(ObservableValue<? extends String> observable, String oldString, String newString) 
	{
		// Grab the instance of the changed object
		StringProperty textProperty = (StringProperty) observable;
		TextField field = (TextField) textProperty.getBean();
		
		if(!oldString.equals(newString))
			switch(field.getId())
			{
				case "playerOneName":
					playerNames[0] = new String(newString);
					break;
				case "playerTwoName":
					playerNames[1] = new String(newString);
					break;
				case "playerThreeName":
					playerNames[2] = new String(newString);
			}
		
		// Check if number of nonempty strings match the number of players
		int ready = 0;
		for(int i = 0; i < 3; i++)
			if(!playerNames[i].isEmpty())
				ready++;
		
		if(ready >= nPlayers)
			createGame.setDisable(false);
		else
			createGame.setDisable(true);
	}
}
