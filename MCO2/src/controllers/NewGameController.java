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

public class NewGameController implements EventHandler<Event>, ChangeListener<String>
{
	private String comboState;
	private int nPlayers;
	
	String[] playerNames;
	
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

	@Override
	public void handle(Event ev)
	{
		if(ev instanceof ActionEvent)
			handle((ActionEvent) ev);
	}
	
	public void handle(ActionEvent ev)
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
					Parent root = newLoader.load();
					
					// Submit nPlayers and playerNames to the next controller
					GameWindowController nextController = newLoader.getController();

					// Create game instance
					ArrayList<String> names = new ArrayList<String>();
					for(int i = 0; i < nPlayers; i++)
						names.add(playerNames[i]);
					nextController.setActiveGame(new ThatsLife(names));
					
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
