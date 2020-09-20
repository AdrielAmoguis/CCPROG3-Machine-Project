package controllers;

import thatslife.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;

public class NewGameController implements EventHandler<Event>
{
	private String comboState;
	private int nPlayers;
	
	public NewGameController()
	{
		comboState = null;
		nPlayers = 0;
	}
	
	@FXML
	ComboBox<String> playerCombo;
	
	@FXML
	Button createGame;
	
	@FXML
	void initialize()
	{
		playerCombo.setOnAction(this::handle);
		playerCombo.getItems().clear();
		playerCombo.getItems().addAll("2 Players", "3 Players");
		
		createGame.setOnAction(this::handle);
		createGame.setDisable(true);
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
				createGame.setDisable(false);
			else
				createGame.setDisable(true);
		}
		else if(ev.getSource() instanceof Button)
		{
			// Pass the number of players to the next controller for the next window
			try
			{
				Stage currentStage = (Stage)((Button) ev.getSource()).getScene().getWindow();
				currentStage.close();
				
				FXMLLoader newLoader = new FXMLLoader(getClass().getResource("/resources/GameWindow.fxml"));
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
}
