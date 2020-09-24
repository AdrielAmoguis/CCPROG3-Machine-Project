package controllers;

import thatslife.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.beans.value.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class GameWindowController implements EventHandler<Event>
{
	private ThatsLife activeGame;
	private ArrayList<GridPane> spaces;
	
	@FXML
	Button spinButton;
	
	@FXML
	Rectangle turnFill;
	
	// Player Details
	
	@FXML Circle playerOneBlob;
	@FXML AnchorPane playerOnePanel; 
	@FXML Label playerOneName; @FXML Label playerOneBalance; @FXML Label playerOneLoan;
	@FXML Button playerOneCareer; @FXML Button playerOneSalary; @FXML Label playerOneMarried;
	@FXML Label playerOneHouse; @FXML Label playerOneChildren;
	
	@FXML Circle playerTwoBlob;
	@FXML AnchorPane playerTwoPanel;
	@FXML Label playerTwoName; @FXML Label playerTwoBalance; @FXML Label playerTwoLoan;
	@FXML Button playerTwoCareer; @FXML Button playerTwoSalary; @FXML Label playerTwoMarried;
	@FXML Label playerTwoHouse; @FXML Label playerTwoChildren;

	@FXML Circle playerThreeBlob;
	@FXML AnchorPane playerThreePanel;
	@FXML Label playerThreeName; @FXML Label playerThreeBalance; @FXML Label playerThreeLoan;
	@FXML Button playerThreeCareer; @FXML Button playerThreeSalary; @FXML Label playerThreeMarried;
	@FXML Label playerThreeHouse; @FXML Label playerThreeChildren;
	
	// Player blobs
	
	
	// START OF GAME SPACES
	@FXML GridPane space1; @FXML GridPane space2; @FXML GridPane space3; @FXML GridPane space4;
	@FXML GridPane space5; @FXML GridPane space6; @FXML GridPane space7; @FXML GridPane space8;
	@FXML GridPane space9;
	
	@FXML GridPane space10; @FXML GridPane space12; @FXML GridPane space13; @FXML GridPane space14;
	@FXML GridPane space15; @FXML GridPane space16; @FXML GridPane space17; @FXML GridPane space18;
	@FXML GridPane space19; @FXML GridPane space20;
	
	@FXML GridPane space21; @FXML GridPane space22; @FXML GridPane space23; @FXML GridPane space24;
	@FXML GridPane space25; @FXML GridPane space26; @FXML GridPane space27; @FXML GridPane space28;
	@FXML GridPane space29; @FXML GridPane space30;
	
	@FXML GridPane space31; @FXML GridPane space32; @FXML GridPane space33; @FXML GridPane space34;
	@FXML GridPane space35; @FXML GridPane space36; @FXML GridPane space37; @FXML GridPane space38;
	@FXML GridPane space39; @FXML GridPane space40;
	
	@FXML GridPane space41; @FXML GridPane space42; @FXML GridPane space43; @FXML GridPane space44;
	@FXML GridPane space45; @FXML GridPane space46; @FXML GridPane space47; @FXML GridPane space48;
	@FXML GridPane space49; @FXML GridPane space50;
	
	@FXML GridPane space51; @FXML GridPane space52; @FXML GridPane space53; @FXML GridPane space54;
	@FXML GridPane space55; @FXML GridPane space56; @FXML GridPane space57; @FXML GridPane space58;
	@FXML GridPane space59; @FXML GridPane space60;
	
	@FXML GridPane space61; @FXML GridPane space62; @FXML GridPane space63; @FXML GridPane space64;
	@FXML GridPane space65; @FXML GridPane space66; @FXML GridPane space67; @FXML GridPane space68;
	@FXML GridPane space69; @FXML GridPane space70;
	
	@FXML GridPane space71; @FXML GridPane space72; @FXML GridPane space73; @FXML GridPane space74;
	@FXML GridPane space75; @FXML GridPane space76; @FXML GridPane space77; @FXML GridPane space78;
	@FXML GridPane space79; @FXML GridPane space80;
	
	@FXML GridPane space81; @FXML GridPane space82; @FXML GridPane space83; @FXML GridPane space84;
	@FXML GridPane space85; @FXML GridPane space86; @FXML GridPane space87; @FXML GridPane space88;
	@FXML GridPane space89; @FXML GridPane space90;
	
	@FXML GridPane space91; @FXML GridPane space92; @FXML GridPane space93; @FXML GridPane space94;
	@FXML GridPane space95; @FXML GridPane space96; @FXML GridPane space97; @FXML GridPane space98;
	@FXML GridPane space99; @FXML GridPane space100;
	
	@FXML GridPane space101; @FXML GridPane space102; @FXML GridPane space103; @FXML GridPane space104;
	@FXML GridPane space105; @FXML GridPane space106; @FXML GridPane space107; @FXML GridPane space108;
	@FXML GridPane space109; @FXML GridPane space110; @FXML GridPane space111; @FXML GridPane space112;
	@FXML GridPane space113; @FXML GridPane space114;
	
	private void initSpaces()
	{
		spaces.add(space1); spaces.add(space2); spaces.add(space3); spaces.add(space4);
		spaces.add(space5); spaces.add(space6); spaces.add(space7); spaces.add(space8);
		spaces.add(space9);
		
		spaces.add(space10); spaces.add(space12); spaces.add(space13); spaces.add(space14);
		spaces.add(space15); spaces.add(space16); spaces.add(space17); spaces.add(space18);
		spaces.add(space19); spaces.add(space20);
		
		spaces.add(space21); spaces.add(space22); spaces.add(space23); spaces.add(space24);
		spaces.add(space25); spaces.add(space26); spaces.add(space27); spaces.add(space28);
		spaces.add(space29); spaces.add(space30);
		
		spaces.add(space31); spaces.add(space32); spaces.add(space33); spaces.add(space34);
		spaces.add(space35); spaces.add(space36); spaces.add(space37); spaces.add(space38);
		spaces.add(space39); spaces.add(space40);
		
		spaces.add(space41); spaces.add(space42); spaces.add(space43); spaces.add(space44);
		spaces.add(space45); spaces.add(space46); spaces.add(space47); spaces.add(space48);
		spaces.add(space49); spaces.add(space50);
		
		spaces.add(space51); spaces.add(space52); spaces.add(space53); spaces.add(space54);
		spaces.add(space55); spaces.add(space56); spaces.add(space57); spaces.add(space58);
		spaces.add(space59); spaces.add(space60);
		
		spaces.add(space61); spaces.add(space62); spaces.add(space63); spaces.add(space64);
		spaces.add(space65); spaces.add(space66); spaces.add(space67); spaces.add(space68);
		spaces.add(space69); spaces.add(space70);
		
		spaces.add(space71); spaces.add(space72); spaces.add(space73); spaces.add(space74);
		spaces.add(space75); spaces.add(space76); spaces.add(space77); spaces.add(space78);
		spaces.add(space79); spaces.add(space80);
		
		spaces.add(space81); spaces.add(space82); spaces.add(space83); spaces.add(space84);
		spaces.add(space85); spaces.add(space86); spaces.add(space87); spaces.add(space88);
		spaces.add(space89); spaces.add(space90);
		
		spaces.add(space91); spaces.add(space92); spaces.add(space93); spaces.add(space94);
		spaces.add(space95); spaces.add(space96); spaces.add(space97); spaces.add(space98);
		spaces.add(space99); spaces.add(space100);
		
		spaces.add(space101); spaces.add(space102); spaces.add(space103); spaces.add(space104);
		spaces.add(space105); spaces.add(space106); spaces.add(space107); spaces.add(space108);
		spaces.add(space109); spaces.add(space110); spaces.add(space111); spaces.add(space112);
		spaces.add(space113); spaces.add(space114);
	}
	
	// END OF GAME SPACES
	
	@FXML
	TextArea messagePrompt;
	
	public GameWindowController(ThatsLife game)
	{
		activeGame = game;
		spaces = new ArrayList<GridPane>();
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
		displayAlert("Welcome! - That's Life!", "Game Started!", "Have fun!", true);
		
		// Populate the Player details
		updatePlayerData();
		
		// Initialize the Space ArrayList
		initSpaces();
		
		// Initialize Player Positions
		updatePlayerPos();
	}
	
	private void updatePlayerData()
	{
		for(int i = 0; i < activeGame.getNumPlayers(); i++)
		{
			// Get the player string
			String playerInfo = activeGame.getPlayerString(i);
			
			// Tokenize the Player String Via \n
			String[] info = playerInfo.split("\n");
			
			// Display the information on their corresponding labels
			switch(i)
			{
				case 0:
					playerOneName.setText(info[0].toUpperCase());
					playerOneBalance.setText(info[1]);
					playerOneLoan.setText(info[2]);
					playerOneMarried.setText(info[5].equalsIgnoreCase("true") ? "HAPPILY MARRIED!" : "STILL SINGLE");
					playerOneHouse.setText(info[6]);
					playerOneChildren.setText(info[7]);
					playerOneBlob.setOpacity(1);
					break;
				case 1:
					playerTwoName.setText(info[0].toUpperCase());
					playerTwoBalance.setText(info[1]);
					playerTwoLoan.setText(info[2]);
					playerTwoMarried.setText(info[5].equalsIgnoreCase("true") ? "HAPPILY MARRIED!" : "STILL SINGLE");
					playerTwoHouse.setText(info[6]);
					playerTwoChildren.setText(info[7]);
					playerTwoBlob.setOpacity(1);
					break;
				case 2:
					playerThreeName.setText(info[0].toUpperCase());
					playerThreeBalance.setText(info[1]);
					playerThreeLoan.setText(info[2]);
					playerThreeMarried.setText(info[5].equalsIgnoreCase("true") ? "HAPPILY MARRIED!" : "STILL SINGLE");
					playerThreeHouse.setText(info[6]);
					playerThreeChildren.setText(info[7]);
					playerTwoBlob.setOpacity(1);
					break;
			}
		}
		// Disable Panel 3 as Needed
		if(activeGame.getNumPlayers() < 3)
		{
			playerThreePanel.setDisable(true);
			playerThreeName.setText("===============");
			playerThreeBalance.setText("---");
			playerThreeLoan.setText("---");
			playerThreeMarried.setText("---");
			playerThreeHouse.setText("---");
			playerThreeChildren.setText("---");
					}
	}
	
	@Override
	public void handle(Event ev) 
	{
		if(ev instanceof ActionEvent)
			handle((ActionEvent) ev);
	}
	
	private void handle(ActionEvent ev)
	{
		// Check for Button
		if(ev.getSource() instanceof Button)
		{
			// Spin Button
			if(((Button) ev.getSource()).getId().equalsIgnoreCase("spinButton"))
			{
				int nextTurn = activeGame.startTurn(ThatsLife.rollNumber());
				updatePlayerData();
				switch(nextTurn)
				{
					case 0:
						turnFill.setFill(Paint.valueOf("#FF6161"));
						break;
					case 1:
						turnFill.setFill(Paint.valueOf("#FFF861"));
						break;
					case 2:
						turnFill.setFill(Paint.valueOf("#61FFB3"));
						break;
				}
			}
			
			// Check for player buttons
			if(((Button) ev.getSource()).getId().startsWith("player"))
			{
				Button button = (Button) ev.getSource();
				
				int playerIndex = -1;
				if(button.getId().contains("One")) playerIndex = 0;
				else if(button.getId().contains("Two")) playerIndex = 1;
				else if(button.getId().contains("Three")) playerIndex = 2;
				String[] playerInfo = activeGame.getPlayerString(playerIndex).split("\n");
				
				String type = button.getId().substring(button.getId().length() - "career".length());
				
				switch(type)
				{
					case "Career":
						// Show player one's career
						displayAlert(playerInfo[0].substring(1, playerInfo[0].length() - 2) + "'s Career", playerInfo[0].substring(1, playerInfo[0].length() - 2) + "'s Career", playerInfo[3], true);
						break;
					case "Salary":
						// Show player one's career
						displayAlert(playerInfo[0].substring(1, playerInfo[0].length() - 2) + "'s Salary", playerInfo[0].substring(1, playerInfo[0].length() - 2) + "'s Salary", playerInfo[4], true);
						break;
				}
			}
		}
	}
	
	private void updatePlayerPos()
	{
		for(int i = 0; i < activeGame.getNumPlayers(); i++)
		{
			String[] info = activeGame.getPlayerString(i).split("\n");
			String spaceInfo = null;
			for(String data : info)
			{
				if(data.startsWith("Current Space : "))
					spaceInfo = data.substring("Current Space : ".length());
			}
			spaceInfo = spaceInfo.substring(1, spaceInfo.length() - 1);
			info = spaceInfo.split(" ");
			int spaceID = Integer.parseInt(info[1]);
			
			// Update blob parent
			switch(i)
			{
				case 1:
					break;
			}
		}
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
				messagePrompt.positionCaret(existingText.length());
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