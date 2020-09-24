package controllers;

import thatslife.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;

import java.util.ArrayList;

import javafx.beans.property.StringProperty;
import javafx.beans.value.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class GameWindowController implements EventHandler<Event>
{
	private ThatsLife activeGame;
	private ArrayList<Rectangle> spaces;
	
	// Player Details
	@FXML AnchorPane playerOnePanel;
	@FXML Label playerOneName; @FXML Label playerOneBalance; @FXML Label playerOneLoan;
	@FXML Button playerOneCareer; @FXML Button playerOneSalary; @FXML Label playerOneMarried;
	@FXML Label playerOneHouse; @FXML Label playerOneChildren;
	
	@FXML AnchorPane playerTwoPanel;
	@FXML Label playerTwoName; @FXML Label playerTwoBalance; @FXML Label playerTwoLoan;
	@FXML Button playerTwoCareer; @FXML Button playerTwoSalary; @FXML Label playerTwoMarried;
	@FXML Label playerTwoHouse; @FXML Label playerTwoChildren;
	
	@FXML AnchorPane playerThreePanel;
	@FXML Label playerThreeName; @FXML Label playerThreeBalance; @FXML Label playerThreeLoan;
	@FXML Button playerThreeCareer; @FXML Button playerThreeSalary; @FXML Label playerThreeMarried;
	@FXML Label playerThreeHouse; @FXML Label playerThreeChildren;
	
	// Player blobs
	
	
	// START OF GAME SPACES
	@FXML Rectangle space1; @FXML Rectangle space2; @FXML Rectangle space3; @FXML Rectangle space4;
	@FXML Rectangle space5; @FXML Rectangle space6; @FXML Rectangle space7; @FXML Rectangle space8;
	@FXML Rectangle space9;
	
	@FXML Rectangle space10; @FXML Rectangle space12; @FXML Rectangle space13; @FXML Rectangle space14;
	@FXML Rectangle space15; @FXML Rectangle space16; @FXML Rectangle space17; @FXML Rectangle space18;
	@FXML Rectangle space19; @FXML Rectangle space20;
	
	@FXML Rectangle space21; @FXML Rectangle space22; @FXML Rectangle space23; @FXML Rectangle space24;
	@FXML Rectangle space25; @FXML Rectangle space26; @FXML Rectangle space27; @FXML Rectangle space28;
	@FXML Rectangle space29; @FXML Rectangle space30;
	
	@FXML Rectangle space31; @FXML Rectangle space32; @FXML Rectangle space33; @FXML Rectangle space34;
	@FXML Rectangle space35; @FXML Rectangle space36; @FXML Rectangle space37; @FXML Rectangle space38;
	@FXML Rectangle space39; @FXML Rectangle space40;
	
	@FXML Rectangle space41; @FXML Rectangle space42; @FXML Rectangle space43; @FXML Rectangle space44;
	@FXML Rectangle space45; @FXML Rectangle space46; @FXML Rectangle space47; @FXML Rectangle space48;
	@FXML Rectangle space49; @FXML Rectangle space50;
	
	@FXML Rectangle space51; @FXML Rectangle space52; @FXML Rectangle space53; @FXML Rectangle space54;
	@FXML Rectangle space55; @FXML Rectangle space56; @FXML Rectangle space57; @FXML Rectangle space58;
	@FXML Rectangle space59; @FXML Rectangle space60;
	
	@FXML Rectangle space61; @FXML Rectangle space62; @FXML Rectangle space63; @FXML Rectangle space64;
	@FXML Rectangle space65; @FXML Rectangle space66; @FXML Rectangle space67; @FXML Rectangle space68;
	@FXML Rectangle space69; @FXML Rectangle space70;
	
	@FXML Rectangle space71; @FXML Rectangle space72; @FXML Rectangle space73; @FXML Rectangle space74;
	@FXML Rectangle space75; @FXML Rectangle space76; @FXML Rectangle space77; @FXML Rectangle space78;
	@FXML Rectangle space79; @FXML Rectangle space80;
	
	@FXML Rectangle space81; @FXML Rectangle space82; @FXML Rectangle space83; @FXML Rectangle space84;
	@FXML Rectangle space85; @FXML Rectangle space86; @FXML Rectangle space87; @FXML Rectangle space88;
	@FXML Rectangle space89; @FXML Rectangle space90;
	
	@FXML Rectangle space91; @FXML Rectangle space92; @FXML Rectangle space93; @FXML Rectangle space94;
	@FXML Rectangle space95; @FXML Rectangle space96; @FXML Rectangle space97; @FXML Rectangle space98;
	@FXML Rectangle space99; @FXML Rectangle space100;
	
	@FXML Rectangle space101; @FXML Rectangle space102; @FXML Rectangle space103; @FXML Rectangle space104;
	@FXML Rectangle space105; @FXML Rectangle space106; @FXML Rectangle space107; @FXML Rectangle space108;
	@FXML Rectangle space109; @FXML Rectangle space110; @FXML Rectangle space111; @FXML Rectangle space112;
	@FXML Rectangle space113; @FXML Rectangle space114;
	
	
	// END OF GAME SPACES
	
	@FXML
	TextArea messagePrompt;
	
	public GameWindowController(ThatsLife game)
	{
		activeGame = game;
		spaces = new ArrayList<Rectangle>();
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
		initPlayers();
		
		// Initialize the Space ArrayList
		initSpaces();
	}
	
	private void initSpaces()
	{
		
	}
	
	private void initPlayers()
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
					break;
				case 1:
					playerTwoName.setText(info[0].toUpperCase());
					playerTwoBalance.setText(info[1]);
					playerTwoLoan.setText(info[2]);
					playerTwoMarried.setText(info[5].equalsIgnoreCase("true") ? "HAPPILY MARRIED!" : "STILL SINGLE");
					playerTwoHouse.setText(info[6]);
					playerTwoChildren.setText(info[7]);
					break;
				case 2:
					playerThreeName.setText(info[0].toUpperCase());
					playerThreeBalance.setText(info[1]);
					playerThreeLoan.setText(info[2]);
					playerThreeMarried.setText(info[5].equalsIgnoreCase("true") ? "HAPPILY MARRIED!" : "STILL SINGLE");
					playerThreeHouse.setText(info[6]);
					playerThreeChildren.setText(info[7]);
					break;
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
	}
	
	@Override
	public void handle(Event ev) 
	{
		if(ev instanceof ActionEvent)
			handle((ActionEvent) ev);
	}
	
	private void handle(ActionEvent ev)
	{
		
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