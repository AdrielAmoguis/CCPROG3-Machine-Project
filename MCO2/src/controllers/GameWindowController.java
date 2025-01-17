package controllers;

import thatslife.*;
import javafx.event.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.*;

import java.util.ArrayList;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class is a controller designed for ThatsLife! game, from CCPROG3 - DLSU CCS.
 * This controller controls the main game window, given the ThatsLife instance model.
 * 
 * @author Adriel Isaiah V. Amoguis
 *
 */
public class GameWindowController implements EventHandler<Event>
{
	/**
	 * The instance of the game currently being played.
	 */
	private ThatsLife activeGame;
	
	/**
	 * An ArrayList that contains all spaces as described in the View's board graphic.
	 * This ArrayList is aligned with the spaces in the model.
	 */
	private ArrayList<AnchorPane> spaces;
	
	@FXML
	Button spinButton;
	
	@FXML
	Rectangle turnFill;
	
	@FXML
	Button gameMenuButton;
	
	// Player Details
	
	Circle playerOneBlob;
	@FXML AnchorPane playerOnePanel; 
	@FXML Label playerOneName; @FXML Label playerOneBalance; @FXML Label playerOneLoan;
	@FXML Button playerOneCareer; @FXML Button playerOneSalary; @FXML Label playerOneMarried;
	@FXML Label playerOneHouse; @FXML Label playerOneChildren; @FXML Button playerOneTransactions;
	
	Circle playerTwoBlob;
	@FXML AnchorPane playerTwoPanel;
	@FXML Label playerTwoName; @FXML Label playerTwoBalance; @FXML Label playerTwoLoan;
	@FXML Button playerTwoCareer; @FXML Button playerTwoSalary; @FXML Label playerTwoMarried;
	@FXML Label playerTwoHouse; @FXML Label playerTwoChildren; @FXML Button playerTwoTransactions;

	Circle playerThreeBlob;
	@FXML AnchorPane playerThreePanel;
	@FXML Label playerThreeName; @FXML Label playerThreeBalance; @FXML Label playerThreeLoan;
	@FXML Button playerThreeCareer; @FXML Button playerThreeSalary; @FXML Label playerThreeMarried;
	@FXML Label playerThreeHouse; @FXML Label playerThreeChildren; @FXML Button playerThreeTransactions;
	
	// Player blobs
	
	
	// START OF GAME SPACES
	@FXML AnchorPane space1; @FXML AnchorPane space2; @FXML AnchorPane space3; @FXML AnchorPane space4;
	@FXML AnchorPane space5; @FXML AnchorPane space6; @FXML AnchorPane space7; @FXML AnchorPane space8;
	@FXML AnchorPane space9;
	
	@FXML AnchorPane space10; @FXML AnchorPane space11; @FXML AnchorPane space12; @FXML AnchorPane space13; @FXML AnchorPane space14;
	@FXML AnchorPane space15; @FXML AnchorPane space16; @FXML AnchorPane space17; @FXML AnchorPane space18;
	@FXML AnchorPane space19; @FXML AnchorPane space20;
	
	@FXML AnchorPane space21; @FXML AnchorPane space22; @FXML AnchorPane space23; @FXML AnchorPane space24;
	@FXML AnchorPane space25; @FXML AnchorPane space26; @FXML AnchorPane space27; @FXML AnchorPane space28;
	@FXML AnchorPane space29; @FXML AnchorPane space30;
	
	@FXML AnchorPane space31; @FXML AnchorPane space32; @FXML AnchorPane space33; @FXML AnchorPane space34;
	@FXML AnchorPane space35; @FXML AnchorPane space36; @FXML AnchorPane space37; @FXML AnchorPane space38;
	@FXML AnchorPane space39; @FXML AnchorPane space40;
	
	@FXML AnchorPane space41; @FXML AnchorPane space42; @FXML AnchorPane space43; @FXML AnchorPane space44;
	@FXML AnchorPane space45; @FXML AnchorPane space46; @FXML AnchorPane space47; @FXML AnchorPane space48;
	@FXML AnchorPane space49; @FXML AnchorPane space50;
	
	@FXML AnchorPane space51; @FXML AnchorPane space52; @FXML AnchorPane space53; @FXML AnchorPane space54;
	@FXML AnchorPane space55; @FXML AnchorPane space56; @FXML AnchorPane space57; @FXML AnchorPane space58;
	@FXML AnchorPane space59; @FXML AnchorPane space60;
	
	@FXML AnchorPane space61; @FXML AnchorPane space62; @FXML AnchorPane space63; @FXML AnchorPane space64;
	@FXML AnchorPane space65; @FXML AnchorPane space66; @FXML AnchorPane space67; @FXML AnchorPane space68;
	@FXML AnchorPane space69; @FXML AnchorPane space70;
	
	@FXML AnchorPane space71; @FXML AnchorPane space72; @FXML AnchorPane space73; @FXML AnchorPane space74;
	@FXML AnchorPane space75; @FXML AnchorPane space76; @FXML AnchorPane space77; @FXML AnchorPane space78;
	@FXML AnchorPane space79; @FXML AnchorPane space80;
	
	@FXML AnchorPane space81; @FXML AnchorPane space82; @FXML AnchorPane space83; @FXML AnchorPane space84;
	@FXML AnchorPane space85; @FXML AnchorPane space86; @FXML AnchorPane space87; @FXML AnchorPane space88;
	@FXML AnchorPane space89; @FXML AnchorPane space90;
	
	@FXML AnchorPane space91; @FXML AnchorPane space92; @FXML AnchorPane space93; @FXML AnchorPane space94;
	@FXML AnchorPane space95; @FXML AnchorPane space96; @FXML AnchorPane space97; @FXML AnchorPane space98;
	@FXML AnchorPane space99; @FXML AnchorPane space100;
	
	@FXML AnchorPane space101; @FXML AnchorPane space102; @FXML AnchorPane space103; @FXML AnchorPane space104;
	@FXML AnchorPane space105; @FXML AnchorPane space106; @FXML AnchorPane space107; @FXML AnchorPane space108;
	@FXML AnchorPane space109; @FXML AnchorPane space110; @FXML AnchorPane space111; @FXML AnchorPane space112;
	@FXML AnchorPane space113; @FXML AnchorPane space114;
	
	@FXML AnchorPane space115; @FXML AnchorPane space116; @FXML AnchorPane space117; @FXML AnchorPane space118;
	@FXML AnchorPane space119; @FXML AnchorPane space120; @FXML AnchorPane space121; @FXML AnchorPane space122;
	@FXML AnchorPane space123; @FXML AnchorPane space124; @FXML AnchorPane space125; @FXML AnchorPane space126;
	@FXML AnchorPane space127; @FXML AnchorPane space128;
	
	@FXML AnchorPane space129; @FXML AnchorPane space130; @FXML AnchorPane space131;
	@FXML AnchorPane space132; @FXML AnchorPane space133; @FXML AnchorPane space134; @FXML AnchorPane space135;
	@FXML AnchorPane space136; @FXML AnchorPane space137; @FXML AnchorPane space138; @FXML AnchorPane space139;
	@FXML AnchorPane space140; @FXML AnchorPane space141;
	
	/**
	 * This method adds all the FXML instances of AnchorPane for the space into a singular ArrayList for indexing purposes.
	 */
	private void initSpaces()
	{
		spaces.clear();
		
		spaces.add(space1); spaces.add(space2); spaces.add(space3); spaces.add(space4);
		spaces.add(space5); spaces.add(space6); spaces.add(space7); spaces.add(space8);
		spaces.add(space9);
		
		spaces.add(space10); spaces.add(space11); spaces.add(space12); spaces.add(space13); spaces.add(space14);
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
		
		spaces.add(space115); spaces.add(space116); spaces.add(space117); spaces.add(space118);
		spaces.add(space119); spaces.add(space120); spaces.add(space121); spaces.add(space122);
		spaces.add(space123); spaces.add(space124); spaces.add(space125); 
		spaces.add(space126); spaces.add(space127);
		
		spaces.add(space128); spaces.add(space129); spaces.add(space130); spaces.add(space131);
		spaces.add(space132); spaces.add(space133); spaces.add(space134); spaces.add(space135);
		spaces.add(space136); spaces.add(space137); spaces.add(space138); spaces.add(space139);
		spaces.add(space140); spaces.add(space141);
	}
	
	// END OF GAME SPACES
	
	@FXML
	TextArea messagePrompt;
	
	/**
	 * This constructor creates an instance of the controller using the game parameter as its active game.
	 * @param game : ThatsLife - the active game model to be played.
	 */
	public GameWindowController(ThatsLife game)
	{
		activeGame = game;
		spaces = new ArrayList<AnchorPane>();
	}
	
	/**
	 * This method sets the game model to control.
	 * @param game : ThatsLife - game model to control.
	 */
	public void setActiveGame(ThatsLife game)
	{
		this.activeGame = game;
	}
	
	/**
	 * This method is used by the FXML Loader to instantiate several elements found in the view.
	 */
	@FXML
	void initialize()
	{
		ThatsLife.setSessionJFXController(this);
		
		// Create the player blobs
		playerOneBlob = new Circle();
		playerOneBlob.setFill(Paint.valueOf("#FF6161"));
		playerOneBlob.setRadius(15);
		playerOneBlob.setStroke(Paint.valueOf("black"));
		
		playerTwoBlob = new Circle();
		playerTwoBlob.setFill(Paint.valueOf("#FFF861"));
		playerTwoBlob.setRadius(15);
		playerTwoBlob.setStroke(Paint.valueOf("black"));
		
		playerThreeBlob = new Circle();
		playerThreeBlob.setFill(Paint.valueOf("#61FFB3"));
		playerThreeBlob.setRadius(15);
		playerThreeBlob.setStroke(Paint.valueOf("black"));
		
		// The Turn Box
		switch(activeGame.getTurn())
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
		
		// Initialize the game
		initializeGame();
	}
	
	/**
	 * This method performs a sequence of events that initializes the view according to initial data in the model.
	 */
	private void initializeGame()
	{
		// Display Preliminary Messages
		final String message = new String(
			"Welcome to That's Life! The Digital Boardgame\n\n" +
			"This game mirrors life events from people going to college, having a career, raising a family, investing, buying a hose, working, and retiring.\n\n" +
			"The goal of this game is for the players to reach retirement as early as possible with the most savings on hand.\n" +
			"The player decides what kind of life he wants to experience during the game. At the start of each round, the player presses for a randomly generated number [1-10].\n" +
			"This determines the number of spaces he will advance on the board. Several events may take place, depending on which spaces on the board the player lands on.\n\n" +
			"Unlike the usual board games, where there is only one path from start to end, That's Life!, at some areas along the way, present players with two options: to continue moving forward\n" +
			"or to take a shorter (or maybe longer) route to reach another space on the board.\n\n"
		);
		
		displayAlert("Welcome! - That's Life!", "How to Play", message, true);
		
		// Populate the Player details
		updatePlayerData();
		
		// Initialize the Space ArrayList
		initSpaces();
		
		// Initialize Player Positions
		updatePlayerPos();
	}
	
	/**
	 * This method updates the sidebar with new player data. It is called every after turn.
	 */
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
					playerOneMarried.setText(info[5].substring("MARRIED : ".length()).equalsIgnoreCase("true") ? "HAPPILY MARRIED!" : "STILL SINGLE");
					playerOneHouse.setText(info[6].substring("[HOUSE] ".length()).equalsIgnoreCase("No House") ? "No House" : info[6].substring("[HOUSE] [HOUSE] ".length()));
					playerOneChildren.setText(info[7]);
					playerOneBlob.setOpacity(1);
					break;
				case 1:
					playerTwoName.setText(info[0].toUpperCase());
					playerTwoBalance.setText(info[1]);
					playerTwoLoan.setText(info[2]);
					playerTwoMarried.setText(info[5].substring("MARRIED : ".length()).equalsIgnoreCase("true") ? "HAPPILY MARRIED!" : "STILL SINGLE");
					playerTwoHouse.setText(info[6].substring("[HOUSE] ".length()).equalsIgnoreCase("No House") ? "No House" : info[6].substring("[HOUSE] [HOUSE] ".length()));
					playerTwoChildren.setText(info[7]);
					playerTwoBlob.setOpacity(1);
					break;
				case 2:
					playerThreeName.setText(info[0].toUpperCase());
					playerThreeBalance.setText(info[1]);
					playerThreeLoan.setText(info[2]);
					playerThreeMarried.setText(info[5].substring("MARRIED : ".length()).equalsIgnoreCase("true") ? "HAPPILY MARRIED!" : "STILL SINGLE");
					playerThreeHouse.setText(info[6].substring("[HOUSE] ".length()).equalsIgnoreCase("No House") ? "No House" : info[6].substring("[HOUSE] [HOUSE] ".length()));
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
	
	/**
	 * This event handler passes ActionEvents to the ActionEvent handler.
	 * @param ev : Event
	 */
	@Override
	public void handle(Event ev) 
	{
		if(ev instanceof ActionEvent)
			handle((ActionEvent) ev);
	}
	
	/**
	 * This event handler handles all ActionEvents in the entire game window.
	 * @param ev : ActionEvent - the event to handle
	 */
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
				
				// Check if game is still ongoing
				if(activeGame.isOngoing())
				{
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
				else
				{
					// Game Finished, bring up the winners' dialog
					String ranking = activeGame.declareRanking();
					double[] balances = activeGame.getFinalBalance();
					
					try
					{
						activeGame.destroy();
						Stage primaryStage = (Stage) ((Button) ev.getSource()).getScene().getWindow();
						primaryStage.close();
						
						// Open new
						FXMLLoader newLoader = new FXMLLoader(getClass().getResource("/resources/WinnerWindow.fxml"));
						newLoader.setController(new WinnerController(ranking, balances));
						
						Parent root = newLoader.load();
						
						primaryStage = new Stage();
						primaryStage.setTitle("Winners - That's Life!");
						primaryStage.setResizable(false);
						primaryStage.setScene(new Scene(root));
						primaryStage.show();
						
						ThatsLife.setSessionJFXController(null);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
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
						displayAlert(playerInfo[0].substring(1, playerInfo[0].length() - 2) + "'s Career", playerInfo[0].substring(1, playerInfo[0].length() - 2) + "'s Career", playerInfo[3], true);
						break;
					case "Salary":
						displayAlert(playerInfo[0].substring(1, playerInfo[0].length() - 2) + "'s Salary", playerInfo[0].substring(1, playerInfo[0].length() - 2) + "'s Salary", playerInfo[4], true);
						break;
					case "ctions":
						Transaction[] playerTransactions = this.activeGame.getPlayerTransactions(playerIndex);
						String transactionMessage = new String();
						if(playerTransactions.length == 0)
							transactionMessage += "Nothing to show";
						else
						{
							for(Transaction record : playerTransactions)
							{
								transactionMessage += record.toString() + "\n";
							}
						}
						displayAlert(playerInfo[0].substring(1, playerInfo[0].length() - 2) + "'s Transactions", playerInfo[0].substring(1, playerInfo[0].length() - 2) + "'s Transactions", transactionMessage, true);
						break;
				}
			}
			
			// Game Menu Button
			if(((Button) ev.getSource()).getId().equals(gameMenuButton.getId()))
			{
				// Open the dialog
				try
				{
					Stage stage = new Stage();
					Stage primaryStage = (Stage) ((Button) ev.getSource()).getScene().getWindow();
					
					FXMLLoader newLoader = new FXMLLoader(getClass().getResource("/resources/GameMenu.fxml"));
					newLoader.setController(new GameMenuController(this.activeGame, primaryStage));
					Parent root = newLoader.load();
					stage.setTitle("Game Menu - That's Life!");
					stage.setResizable(false);
					stage.setScene(new Scene(root));
					
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.showAndWait();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * This method updates the view with the current player positions at the time of calling.
	 * This method relies heavily on the the ThatsLife class' getPlayerString() method. It tokenizes
	 * and parses the string to extract the player's current space ID.
	 */
	public void updatePlayerPos()
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
			AnchorPane newSpace, oldSpace;
			switch(i)
			{
				case 0:
					// Remove from old Space
					oldSpace = (AnchorPane) playerOneBlob.getParent();
					if(oldSpace != null)
						oldSpace.getChildren().remove(playerOneBlob);
					
					// Add to current space
					newSpace = spaces.get(spaceID - 1);
					newSpace.getChildren().add(playerOneBlob);
					AnchorPane.setTopAnchor(playerOneBlob, 5.0);
					AnchorPane.setLeftAnchor(playerOneBlob, 5.0);
					break;
					
				case 1:
					// Remove from old Space
					oldSpace = (AnchorPane) playerTwoBlob.getParent();
					if(oldSpace != null)
						oldSpace.getChildren().remove(playerTwoBlob);
					
					// Add to current space
					newSpace = spaces.get(spaceID - 1);
					newSpace.getChildren().add(playerTwoBlob);
					AnchorPane.setBottomAnchor(playerTwoBlob, 5.0);
					AnchorPane.setRightAnchor(playerTwoBlob, 5.0);
					break;
					
				case 2:
					// Remove from old Space
					oldSpace = (AnchorPane) playerThreeBlob.getParent();
					if(oldSpace != null)
						oldSpace.getChildren().remove(playerThreeBlob);
					
					// Add to current space
					newSpace = spaces.get(spaceID - 1);
					newSpace.getChildren().add(playerThreeBlob);
					AnchorPane.setTopAnchor(playerThreeBlob, 5.0);
					AnchorPane.setRightAnchor(playerThreeBlob, 5.0);
					break;
			}
		}
	}
	
	// CHOICE DIALOG
	/**
	 * This method shows an alert box that prompts the user to make a choice via a drop-down menu.
	 * @param prompt : The prompt string to present to the user.
	 * @param choices : The String array that presents all the choices the user can make.
	 * @return An integer that is aligned with the index of the choices array that the player chose.
	 */
	public int displayDecision(String prompt, String[] choices)
	{
		int decision = -1;
		String selected = null;
		ChoiceDialog<String> choiceDialog = new ChoiceDialog<String>(choices[0], choices);
		choiceDialog.setContentText(prompt);
		choiceDialog.setHeaderText("Make a Decision - That's Life");
		
		// Add styles
		DialogPane pane = choiceDialog.getDialogPane();
		pane.getStylesheets().add(getClass().getResource("/resources/styles.css").toExternalForm());
		pane.getStyleClass().add("alertDialog");
		
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
	/**
	 * This method shows a prompt message to the user by printing it to the message prompter textfield.
	 * @param prompt : Message to print
	 */
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
	/**
	 * This method displays an alert box based on the given parameters.
	 * @param title : String - the title of the alert box. 
	 * @param header : String - the header of the alert box.
	 * @param prompt : String - the content text of the alert box.
	 * @param willWait : boolean - Determined if the alert box should freeze the game until it is dismissed or not.
	 */
	public void displayAlert(String title, String header, String prompt, boolean willWait)
	{
		Alert aBox = new Alert(Alert.AlertType.INFORMATION);
		
		aBox.setContentText(prompt);
		aBox.setTitle(title);
		aBox.setHeaderText(header);
	
		// Add styles
		DialogPane pane = aBox.getDialogPane();
		pane.getStylesheets().add(getClass().getResource("/resources/styles.css").toExternalForm());
		pane.getStyleClass().add("alertDialog");
		
		if(willWait)
			aBox.showAndWait();
		else
			aBox.show();
	}
}